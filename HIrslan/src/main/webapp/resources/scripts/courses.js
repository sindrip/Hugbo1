document.addEventListener('DOMContentLoaded', () => {
    Namskeid.init();
});

let Namskeid = (() => {
    // Listi af Course geymdur í minni
    let courseList = {};

    let init = () => {
        bindHandlers();
        getCourse();
    };

    // Sækir öll course frá APA
    let getCourse = () => {
        const url = document.location.origin + '/api/namskeid';

        $.ajax({
            url,
            type: 'GET',
            success: (res) => {
                courseList = res;
                courseToDom();
            },
            error: function() {
            }
        });
    };

    // Setur Course úr minni inn í DOMið
    let courseToDom = () => {
        const courseTable = $('#courseTable tbody');

        let tableHtml = '';
        courseList.forEach((course) => {
            const nafn = course.nafn;
            const numer = course.numer;
            const langtNumer = course.langtNumer;

            tableHtml += '<tr data-id="' + langtNumer + '">';
            tableHtml += '<td>' + nafn;
            tableHtml += '<td>' + numer;
            tableHtml += '</tr>';
        });

        courseTable.html(tableHtml);
    };

    // Event handlerar
    let bindHandlers = () => {
        $('#searchCourse').on('submit', function(e) {
            e.preventDefault();
            searchCourseHandler($(this).serialize());
            return false;
        });

        $("#courseTable tbody").on("click", "tr", function(){
            var clickedRow = $(this);
            if (clickedRow.data('id')) {
                document.location = document.location.origin + '/namskeid/' + clickedRow.data('id');
            }
        });
    };

    // Kallar á bakenda til að leita eftir leitarstreng
    let searchCourseHandler = (val) => {
        const url = document.location.origin + '/api/namskeid/leit?' + val;

        $.ajax({
            url,
            type: 'GET',
            success: (res) => {
                courseList = res;
                courseToDom();
            },
            error: function() {
            }
        });
    };

    return {
        init,
    };
})();