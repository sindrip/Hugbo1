document.addEventListener('DOMContentLoaded', () => {
    Signup.init();
});

let Signup = (() => {

    let init = () => {
        console.log('script loaded');
        bindHandlers();
    };

    // Event handlerar
    let bindHandlers = () => {
        $('#signupForm').on('submit', function(e) {
            e.preventDefault();
            const form = {
                name: $('#name').val(),
                email: $('#email').val(),
                password: $('#password').val(),
                passwordConfirm: $('#password-confirm').val(),
            }
            console.log(form);
            if(form.password !== form.passwordConfirm) {
                $('#passwordError').html('Lykilorð eru ekki eins!')
            } else {
                // Remove duplicate password if match
                delete form.passwordConfirm;
                signupHandler(form);
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
                console.log(res);
            },
            error: function() {
                console.log('ajax error');
            }
        });
    };

    return {
        init,
    };
})();