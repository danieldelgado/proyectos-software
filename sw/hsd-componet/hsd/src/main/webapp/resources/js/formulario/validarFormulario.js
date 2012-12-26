var formulario;
var form = null;
var idcontent = "";
var entidad = "Parametro";
$(function() {
	
	entidad = $("#entidad").val();	

	mensaje_consola(entidad);
	
	mensaje_consola(idcontent);
	
	formulario = $(".formulario "+idcontent);	
		
	cargarValidateForm();
	
/*	$(".clGuardar").button().click(function() {
		formulario.submit();
	});
*/
	
});

function cargarValidateForm() {
	if (formulario != null) {		
		var validateParam = {};		
		var data = null;
		
		ajaxSyncMap({
		        type : "get",
		        url: context+"valacion/parametros/"+entidad,
		        async:  false,
		        dataType :"json",
		        success:  function (resp) {		        	
		        	data = resp;
		        	$.each(data, function(index, value) { 
						if(value!=null){										
							$.each(value, function(option, value) { 						
								if(value!=null){	
									var campos = {};			
									$.each(value, function(index, value) {
										$.each(value, function(index, value) {											
											var reglas = {};
											$.each(value, function(index, value) {												
												reglas[index] = value;
											});	
											campos[index]=reglas;
										});	

									});	
									validateParam[option]=campos;									
								}							
							});				
						}				
					});	
		        }
		    });

		mensaje_consola("formulario validate id");
		mensaje_consola(formulario.attr("id"));
		mensaje_consola("formulario validate class");
		mensaje_consola(formulario.attr("class"));
		
		var vlt = formulario.validate({
					debug : true,
					rules :	
						validateParam.rules,
					messages :
						validateParam.messages,
					submitHandler : function(form) {
						mensaje_consola('El formulario ha sido validado correctamente!');
					}
				});		
	}

}