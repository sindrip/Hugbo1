/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 */


/*
    Kallar á init fallið í hlutnum Namskeid þegar síðan hleðst. Init fallið hefur upphafsstillinu siðunnar
 */
document.addEventListener('DOMContentLoaded', () => {
    Namskeid.init();
});

let Namskeid = (() => {
    // Listi af Course geymdur í minni
    let courseList = {};

    //Fall sem kallar á bindHandlers og getCourse í við ræsingu
    let init = () => {
        bindHandlers();
        getCourse();
    };

    // Sækir öll course frá APA
    let getCourse = () => {
        const url = document.location.origin + '/api/namskeid';
        courseToDom([{nafn:'Leita að námskeiðum.',numer:'',langtNumer:'..'}]);

        $.ajax({
            url,
            type: 'GET',
            success: (res) => {
                courseList = res;
                console.log(courseList)
                courseToDom(res);
            },
            error: function() {
                courseToDom([{nafn:'Næ ekki að tengjast við þjónustu.',numer:'',langtNumer:'..'}]);
            }
        });
    };

    // Setur Course úr minni inn í DOMið
    let courseToDom = (coursesList) => {
        const courseTable = $('#courseTable tbody');
        console.log(coursesList)
        let tableHtml = '';
        coursesList.forEach((course) => {
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

    // Event handlerar. Setur event handler á dom elements
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
                courseToDom(res);
            },
            error: function() {
            }
        });
    };

    return {
        init,
    };
})();