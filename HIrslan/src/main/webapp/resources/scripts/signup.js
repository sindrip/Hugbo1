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
            signupHandler($(this).serialize());
            return false;
        });
    };

    // Kallar á bakenda til að leita eftir leitarstreng
    let signupHandler = (val) => {
        const url = document.location.origin + '/api/signup;

        $.ajax({
            url,
            type: 'GET',
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