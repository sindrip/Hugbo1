document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});

    let Login = (() => {

        let init = () => {
        console.log('script loaded');
        logoutHandler();
    }

    let logoutHandler = () => {
        const url = document.location.origin + '/api/users/me/logout';
        $.ajax({
            url,
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            success: (res, status, xhr ) => {
                console.log('flott');
                document.location = "/";
            },
            error: function(e) {
                console.log(e)
                console.log('ohh noooo, ajax error');
                alert('Ekki tókst að skrá út');
            }
        });
    }

    return {
        init,
    }
})();