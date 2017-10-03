document.addEventListener('DOMContentLoaded', () => {
    NamskeidReview.init();
});

let NamskeidReview = (() => {
        let init = () => {
        console.log('script loaded');
bindHandlers();
};

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
    });--
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
        },
        error: function() {
            console.log('ohh noooo, ajax error');
        }
    });
};

return {
    init,
};
})();
