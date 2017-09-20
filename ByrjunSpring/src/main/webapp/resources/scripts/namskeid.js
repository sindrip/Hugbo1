document.addEventListener('DOMContentLoaded', () => {
    Namskeid.init();
});

let Namskeid = (() => {
    let namskeid = {};

    let getNamskeid = () => {
      const url = document.location.origin + '/api/namskeid';

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

    let init = () => {
        console.log('script loaded')
        getNamskeid();
    };



    return {
        init,
    };
})();
