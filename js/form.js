$(document).ready(function(){

	$('#form_valid').trigger("reset");
	$('#mensagem').val('');

	$('input').on('input', function(){
	 	var $el = $(this);
	 	if (this.checkValidity()) {
	    	$el.removeClass('error');
	    	$el.addClass('ok');
		} else {
			$el.removeClass('ok');
	    	$el.addClass('error');
		}
	});

	//reset após correto submit
	

	$(function($) {
		$('#form_valid').submit(function(){
			alert('dados enviados com sucesso!');	
			window.location="index.html";
		});
	});

});