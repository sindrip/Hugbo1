/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 */


/*
    * @description Þegar síðan hleðst inn þá kallar það á init fallið í Login.
 */
document.addEventListener('DOMContentLoaded', () => {
    Login.init();
});


/*
    * @description Object sér um að upphafsstilingu síðunnar
 */
let Login = (() => {

    /*
        * Kallar á bindHandlers fallið
     */
    let init = () => {
        console.log('script loaded');
        bindHandlers();
    }

    /*
        * @description Setur event handlerá öll elements með loginForm Id
        * @param ekkert
        * @return ekkert
     */
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


/*
    * @description Sendir skilaboð til bakendans.
    * @param val login strengur
    * @return Skilar engur
 */
let loginHandler = (val) => {
    const url = document.location.origin + '/api/users/login';
    console.log(val);
    $.ajax({
        url,
        type: 'POST',
        data: JSON.stringify(val),
        contentType: 'application/json; charset=utf-8',
        success: (res, status, xhr ) => {
            // console.log(res);
            window.location = '/';
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