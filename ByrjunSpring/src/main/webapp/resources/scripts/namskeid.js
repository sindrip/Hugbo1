document.addEventListener('DOMContentLoaded', () => {
    Namskeid.init();
});

let Namskeid = (() => {
    let namskeidList = {};

    let getNamskeid = () => {
      const url = document.location.origin + '/api/namskeid';

      $.ajax({
        url,
        type: 'GET',
        success: (res) => {
          console.log(res);
          namskeidList = res;
          namskeidToDom();
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

    let namskeidToDom = () => {
      const namskeidTable = $('#namskeidTable tbody');

      let tableHtml = '';
      namskeidList.forEach((namskeid) => {
        const nafn = namskeid.nafn;
        const numer = namskeid.numer;

        tableHtml += '<tr>';
        tableHtml += '<td>' + nafn;
        tableHtml += '<td>' + numer;
        tableHtml += '</tr>';

      });

      namskeidTable.html(tableHtml);
    };



    return {
        init,
    };
})();
