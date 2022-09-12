jQuery.fn.hideSolution=function() {
	return this.each(function() {
		$(this).addClass('solved').wrapInner('<div style="display:none;"></div>').children().hide().end().prepend('<a class="showSol" href="javascript:void(0);">Solution</a>').children(':first').click(function(event) {
			event.preventDefault();
			$(this).toggleClass('showSol').toggleClass('hideSol').siblings().slideToggle('fast');
		});
		if ($(this).hasClass('boxed')) {
			$(this).removeClass('boxed').find('div').first().addClass('boxed');
		}
	});
};
$(function() {
	$('sol').each(function() {
		$('<div class="solution">' + $(this).html() + '</div>').replaceAll($(this)).addClass( this.className ).attr( 'style', $(this).attr('style') );
	});
	$('div.solution').hideSolution();
	$('.showAllSolutions').append('<button class="showAll">All Solutions</button>')
		.children(':first').click(function(event) {
			event.preventDefault();
			$(this).toggleClass('showAll');
			( $(this).hasClass('showAll') ? $('a.hideSol') : $('a.showSol') ).click();
		});
	var enable = $('div.enableSolutions');
	if (enable.length > 0) {
		$('.showSol, button.showAll').hide();
		$('div.enableSolutions').append('<button>Enable Solutions</button>').children(':first')
			.click(function() {
				if (confirm('Are you sure you want to be able to see solutions?')) {
					$(this).hide(400).promise().then( function() { $(this).remove(); });
					$('.showSol, button.showAll').show(400);
				}
			});
	}
});
