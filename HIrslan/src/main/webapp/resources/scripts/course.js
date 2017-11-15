/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 */
// Binds the javascript after DOM has loaded
document.addEventListener('DOMContentLoaded', () => {
    NamskeidReview.init();
});

// Javascript encapsulator
let NamskeidReview = (() => {
        // Course that was fetched
        let course = {};
    // Inits the encapsulator by binding handlers and fetching initial courses
    let init = () => {
        console.log('script loaded');
        bindHandlers();
        getCourse();
    };
    // Connects to backend endpoint and gets data
    let getCourse = () => {
        // Endpoint for comments
        const urlReview = document.location.origin + '/api/review' + window.location.pathname;
        // Endpoint for reviewInfo
        const urlCourse = document.location.origin + '/api' + window.location.pathname;
        // Displays that info is being fetched while loading
        reviewsToDom([{createdOn: new Date(), author: 'Sæki gögn', mainText: 'Sæki gögn', rating: 5}]);
        // Endpoint call
        $.ajax({
            url: urlReview,
            type: 'GET',
            success: (res) => {
                reviewsToDom(res);
            },
            error: () => {
            }
        })
    // Endpoint call
    $.ajax({
            url: urlCourse,
            type: 'GET',
            success: (res) => {
                courseToDom(res);
            },
            error: () => {
            }
        })
    };
    // Logic for selecting star color by grade
    let getColor = (grade) => {
        let color = '';
        if(grade > 4) color = 'green';
        else if(grade > 2) color = 'yellow';
        else color = 'red';
        return color;
    };

    // Builds DOM table from ajax result
    let courseToDom = (course) => {

        // The element to update
        const courseDiv =$('#courseInfo');

        const nameDiv = '<h4 class="card-title">' + course.nafn + '</h4>';
        const numbDiv = '<h6 class="card-subtitle mb-2 text-muted">' + course.numer + '</h6>';
        let textDiv = '<p class="card-text">Lýsing á námskeiði hér.</p>';
        const starIco = '<i class="fa fa-star icon" style="color:' + getColor(course.averageRank) + ';"></i>' + course.averageRank.toPrecision(3);
        textDiv = '';
        const grade = course.averageRank > 0 ? starIco : '<div><p>Enginn einkunn gefinn.</p></div>';

        const cardBlock = '<div class="card-block">' + nameDiv + numbDiv + textDiv + grade + '</div>';
        const card = '<div class="card card-header col-sm-8">' + cardBlock + '</div>';

        courseDiv.html(card);
    };

    // Builds DOM table from ajax result
    let reviewsToDom = (comments) => {
        // The element to update
        const reviewDiv = $('#courseComment');
        let commentDOM = '';

        // Builds HTML structure for each comment
        comments.forEach((comment) => {
            const authorValue = comment.author  ? comment.author : 'Óþekktur höfundur';
            const dateValue = comment.createdOn  ? new Date(comment.createdOn).toUTCString() : 'Einhvern tímann';
            const authorAnc = '<a href="#"><b>' + authorValue + '</b></a>';
            const authorText = '<div class="title h5">' + authorAnc + ' skrifaði ummæli.</div>';
            const timeText = '<h6 class="text-muted time">Skrifað: ' + dateValue + '</h6>';
            const metaDiv = '<div class="pull-left meta">' + authorText + timeText + '</div>';
            const headingDiv = '<div class="post-heading">' + metaDiv + '</div>';
            const mainText = '<p>' + comment.mainText + '</p>';
            const starImg = '<i class="fa fa-star icon" style="color:' + getColor(comment.rating) + ';"></i>' + comment.rating;
            const starAnc = '<a href="#" class="btn btn-default stat-item">' + starImg + '</a>';
            const starDiv = '<div class="stats">' + starAnc + '</div>';
            const mainDiv = '<div class="post-description">' + mainText + starDiv + '</div>';
            const panel = '<div class="panel panel-white post panel-shadow">' + headingDiv + mainDiv + '</div>';
            const widthDiv = '<div class="col-sm-8">' + panel + '</div>';
            commentDOM += '<div class="row comment">' + widthDiv + '</div>';
        });
        reviewDiv.html(commentDOM);
    };

    // Event handlers bound
    let bindHandlers = () => {
        // On form submit
        $('#reviewForm').on('submit', function(e) {
            e.preventDefault();
            addReviewHandler({
                mainText: $('#reviewText').val(),
                rating: $('#courseGrade').val(),
                author: $('#userEmail').val(),
            });
            return false;
        });
    };

    // Kallar á bakenda til að leita eftir leitarstreng
    let addReviewHandler = (val) => {
        const url = '/api/review' + window.location.pathname;

        $.ajax({
            url,
            type: 'POST',
            data: JSON.stringify(val),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: (res) => {
                location.reload();
            },
            error: function() {
                alert('Ekki tókst að vista ummæli');
            }
        });
    };
    // Global function available outside of encapsulation
    return {
        init,
    };
})();
