document.addEventListener('DOMContentLoaded', () => {
    NamskeidReview.init();
});

let NamskeidReview = (() => {
        // Course that was fetched
        let course = {};

let init = () => {
    console.log('script loaded');
    bindHandlers();
    getCourse();
};

let getCourse = () => {
    const urlReview = document.location.origin + '/api/review' + window.location.pathname;
    const urlCourse = document.location.origin + '/api/review' + window.location.pathname;

    $.ajax({
        url: urlReview,
        type: 'GET',
        success: (res) => {
            console.log('building comments');
            console.log(res);
            reviewsToDom(res);
        },
        error: () => {
            console.log('ajax error');
        }
    })
    $.ajax({
        url: urlCourse,
        type: 'GET',
        success: (res) => {
            console.log('building course');
            console.log(res)
            courseToDom(res);
        },
        error: () => {
            console.log('ajax error');
        }
    })
}

// Builds DOM table from ajax result
let reviewsToDom = (comments) => {
    const courseDiv = $('#courseComment');
    let commentDOM = '';

    comments.forEach((comment) => {
        const authorAnc = '<a href="#"><b>' + comment.author + '</b></a>';
        const authorText = '<div class="title h5">' + authorAnc + ' skrifaði ummæli.</div>';
        const timeText = '<h6 class="text-muted time">' + comment.createdOn + '</h6>';
        const metaDiv = '<div class="pull-left meta">' + authorText + timeText + '</div>';
        const headingDiv = '<div class="post-heading">' + metaDiv + '</div>';
        const mainText = '<p>' + comment.mainText + '</p>';
        const starImg = '<i class="fa fa-star icon"></i>' + comment.rating;
        const starAnc = '<a href="#" class="btn btn-default stat-item">' + starImg + '</a>';
        const starDiv = '<div class="stats">' + starAnc + '</div>';
        const mainDiv = '<div class="post-description">' + mainText + starDiv + '</div>';
        const panel = '<div class="panel panel-white post panel-shadow">' + headingDiv + mainDiv + '</div>';
        const widthDiv = '<div class="col-sm-8">' + panel + '</div>';
        commentDOM += '<div class="row comment">' + widthDiv + '</div>';
    });
    courseDiv.html(commentDOM);
}
// Event handlerar
let bindHandlers = () => {
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
    console.log(JSON.stringify(val));
    const url = '/api/review' + window.location.pathname;
    console.log(url);

    $.ajax({
            url,
            type: 'POST',
            data: JSON.stringify(val),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: (res) => {
            console.log(res);
    location.reload();
},
    error: function() {
        console.log('ohh noooo, ajax error');
        alert('Ekki tókst að vista ummæli');
    }
});
};

return {
    init,
};
})();
