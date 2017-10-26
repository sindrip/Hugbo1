document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});

let Login = (() => {

    let init = () => {
        console.log('script loaded');
        bindHandlers();
    }

    // Event handlerar
let bindHandlers = () => {
    $('#loginForm').on('submit', function(e) {
        console.log('am button')
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
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: (res) => {
            console.log(res);
            // location.reload();
        },
        error: function() {
            console.log('ohh noooo, ajax error');
            alert('Ekki tókst að skra inn');
        }
    });
}


    return {
        init,
    }
})();