
var formulario = null;
var rand = "";
var codigoEntidad = "";

$(function() {	
	codigoEntidad = $("#codigoFormulario").val();		
});


function guardaFormularioSubmit(rand,url){	
	consola("rand:"+rand + " url:"+url);
	consola(formulario);
	this.rand = rand;
	if(formulario==null){
		formulario = $(".formulario-"+rand);	
		validarFormulario(codigoEntidad);
		formulario.action = url;
	}	
//	formulario.submit();
}





function validarFormulario(codEnt) {
	if (formulario != null) {		
//		var validateParam = {};		
		var data = null;		
		ajaxSyncMap({
		        type : "get",
		        url: context+"valacion/parametros/"+codEnt,
		        async:  false,
		        dataType :"json",
		        success:  function (resp) {		        	
		        	data = resp;
		        	consola("data");
		        	consola(data);
//		        	$.each(data, function(index, value) { 
//						if(value!=null){										
//							$.each(value, function(option, value) { 						
//								if(value!=null){	
//									var campos = {};			
//									$.each(value, function(index, value) {
//										$.each(value, function(index, value) {											
//											var reglas = {};
//											$.each(value, function(index, value) {												
//												reglas[index] = value;
//											});	
//											campos[index]=reglas;
//										});	
//
//									});	
//									validateParam[option]=campos;									
//								}							
//							});				
//						}				
//					});	
		        }
		    });

//		consola("formulario validate id");
//		consola(formulario.attr("id"));
//		consola("formulario validate class");
//		consola(formulario.attr("class"));
//		
//		var vlt = formulario.validate({
//					debug : true,
//					rules :	
//						validateParam.rules,
//					messages :
//						validateParam.messages,
//					submitHandler : function(form) {
//						mensaje_consola('El formulario ha sido validado correctamente!');
//					}
//				});		
	}

}