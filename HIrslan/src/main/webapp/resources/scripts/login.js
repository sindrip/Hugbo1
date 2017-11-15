document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});

let Login = (() => {

    let init = () => {
        bindHandlers();
    }

    // Event handlerar
let bindHandlers = () => {
    $('#loginForm').on('submit', function(e) {
        e.preventDefault();
        loginHandler({
            username: $('#inputEmail').val(),
            password: $('#inputPassword').val(),
        });
        return false;
    });
};

let loginHandler = (val) => {
    const url = document.location.origin + '/api/users/login';
    console.log(val);
    $.ajax({
        url,
        type: 'POST',
        data: JSON.stringify(val),
        contentType: 'application/json; charset=utf-8',
        success: (res, status, xhr ) => {
            window.location = '/';
        },
        error: function(e) {
            alert('Ekki tókst að skra inn');
        }
    });
}


    return {
        init,
    }
})();