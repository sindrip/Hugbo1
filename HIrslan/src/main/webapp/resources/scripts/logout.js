/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 */


/*
    * @description Bindur kallar á init fallið í Login objectinum
 */
document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});

    /*
        Login object. Inniheldur aðgerðir fyrir logout
     */

    /*
        kallar á logout handler
     */
    let Login = (() => {

        let init = () => {
        console.log('script loaded');
        logoutHandler();
    }

    /*
        @description Sér um að skrá notanda út
        @param Ekkert
        @return Ekkert
     */
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