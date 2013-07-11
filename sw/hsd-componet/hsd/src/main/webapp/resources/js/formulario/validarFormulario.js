$.fn.validarFormulario = function(){   
	var formulario = $(this).find("form");
//	var rand = $($(this),"#rand");
	var codigoFormulario = $($(this),"#codigoFormulario");

	if (formulario != null) {		
//		var validateParam = {};		
		var data = null;		
		ajaxSyncMap({
		        type : "get",
		        url: context+"valacion/parametros/"+codigoFormulario,
		        async:  false,
		        dataType :"json",
		        success:  function (resp) {		        	
		        	data = resp;
		        	console.log("data");
		        	console.log(data);
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

//		console.log("formulario validate id");
//		console.log(formulario.attr("id"));
//		console.log("formulario validate class");
//		console.log(formulario.attr("class"));
//		
//		var vlt = formulario.validate({
//					debug : true,
//					rules :	
//						validateParam.rules,
//					messages :
//						validateParam.messages,
//					submitHandler : function(form) {
//						mensaje_console.log('El formulario ha sido validado correctamente!');
//					}
//				});		
	}

};