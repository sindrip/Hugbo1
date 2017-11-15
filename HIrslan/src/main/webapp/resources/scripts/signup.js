/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 */


/*
    * @description Bindur kallar á init fallið í Signup objectinum
 */
document.addEventListener('DOMContentLoaded', () => {
    Signup.init();
});

let Signup = (() => {

    /*
        * @description  Kallar á bindHandler
     */
    let init = () => {
        console.log('script loaded');
        bindHandlers();
    };

    /* @description Bindur handera á elements
        @param Ekkert
        return Ekkert
     */

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

    /*
        * @description Sendir Gögn um nýskráningu á bakenda
        * @param nýskráningar object
        * @return ekkert
     */
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
                document.location = "/login";
            },
            error: function (xhr, status, error) {
                console.log('ajax error');
                console.log(xhr.status);
                console.log(xhr.responseText);
                console.log('her', xhr, status, error)
            }
        });
    };

    return {
        init,
    };
})();