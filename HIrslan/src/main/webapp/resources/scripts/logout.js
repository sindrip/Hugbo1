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
        // location.reload();
    },
        error: function(e) {
        console.log(e)
        console.log('ohh noooo, ajax error');
        alert('Ekki tókst að skra inn');
    }
});
}


return {
    init,
}
})();