var observe;
if (window.attachEvent) {
    observe = function (element, event, handler) {
        element.attachEvent('on'+event, handler);
    };
}
else {
    observe = function (element, event, handler) {
        element.addEventListener(event, handler, false);
    };
}
function init () {
    var text = document.getElementById('text');
    function resize () {
        text.style.height = 'auto';
        text.style.height = text.scrollHeight+'px';
        //scroll to bottom of the page
        window.scrollTo(0,document.body.scrollHeight);
    }
    function delayedResize () {
        window.setTimeout(resize, 0);
    }
    observe(text, 'change',  resize);
    observe(text, 'cut',     delayedResize);
    observe(text, 'paste',   delayedResize);
    observe(text, 'drop',    delayedResize);
    observe(text, 'keydown', delayedResize);
    //text.focus();
    //text.select();
    resize();
}
function disappear(){
	document.getElementById("error").style.display = "none";
}
$( document ).ready(function() {
	$('#mySelect').change(function() {
	    var width = $(this).width();
	    var height = $(this).height();
	    var chosen = $("option:selected", this).text();
	    if(chosen != 'Tạo loại sách mới.'){
	    	$("#ipLoai").val("");
	    }
	    $(this).next(".ninja-input")
	         .css({width: width - 10, height: height + 10})
	         .toggleClass("hidden", chosen != 'Tạo loại sách mới.');
	});
});