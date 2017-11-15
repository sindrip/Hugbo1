document.addEventListener('DOMContentLoaded', () => {
    Signup.init();
});

let Signup = (() => {

    let init = () => {
        bindHandlers();
    };

    // Event handlerar
    let bindHandlers = () => {
        $('#signupForm').on('submit', function(e) {
            e.preventDefault();
            const form = {
                email: $('#email').val(),
                password: $('#password').val(),
                passwordConfirm: $('#password-confirm').val(),
            }
            if(form.password !== form.passwordConfirm) {
                $('#passwordError').html('Lykilorð eru ekki eins!')
            } else {
                // Remove duplicate password if match
                //delete form.passwordConfirm;
                const user = {
                    username: form.email,
                    password: form.password,
                };
                signupHandler(user);
            }
            return false;
        });
    };

    // Kallar á bakenda til að leita eftir leitarstreng
    let signupHandler = (val) => {
        const url = document.location.origin + '/api/users/signup';

        $.ajax({
            url,
            type: 'POST',
            data: JSON.stringify(val),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: (res) => {
                document.location = "/login";
            },
            error: function (xhr, status, error) {
                if(xhr.status === 409){
                    alert(xhr.responseText);
                }
            }
        });
    };

    return {
        init,
    };
})();