document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});

    let Login = (() => {

        let init = () => {
        logoutHandler();
    }

    let logoutHandler = () => {
        const url = document.location.origin + '/api/users/me/logout';
        $.ajax({
            url,
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            success: (res, status, xhr ) => {
                document.location = "/";
            },
            error: function(e) {
                alert('Ekki tókst að skrá út');
            }
        });
    }

    return {
        init,
    }
})();