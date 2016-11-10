$(document).ready(function(){
	//todo novo carregamento da pagina limpar os campos
	$('#form_valid').trigger("reset");
	$('#mensagem').val('');
	//adiciona uma classe que define o background cor verde(correto) ou amarelo(incorreto) na hora do preenchimento
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
	//informa se as informações foram enviadas, e encaminha para a pagina home nesse caso como não tem, o proprio form.
	$(function($) {
		$('#form_valid').submit(function(){
			alert('dados enviados com sucesso!');	
			window.location="index.html";
		});
	});

});