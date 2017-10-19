document.addEventListener('DOMContentLoaded', () => {
    User.init();
});

let User = (() => {
let init = () => {
    console.log('script loaded');
};

return {
    init,
};
})();