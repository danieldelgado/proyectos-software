var formulario;
var form = null;
var idcontent = "";
var entidad = "Parametro";
$(function() {
	formulario = $(".formulario "+idcontent);
		
	cargarValidateForm();
	
	$(".clGuardar").button().click(function() {
		formulario.submit();
	});
	
});

function cargarValidateForm() {
	if (formulario != null) {
		
		var validateParam = null;//new Array();
		 $.ajax({
		        type : "get",
		        url: context+"valacion/parametros/"+entidad,
		        async:  false,
		        dataType :"json",
		        success:  function (resp) {
		        	validateParam=resp;
		        }
		    });
		 
         mensaje_consola("rules");
         mensaje_consola(validateParam);
		formulario.validate({
					debug : true,
					rules :	
					{
						'entidad':{minlength:4, required:true},
						'valor':{}
					
					} 

						,
						
						/*
						 * {"entidad":{minlength:4,required:true}}
						 * 
						 * validateParam.rules.result,
								
						*/
						/* {
						'entidad' : 'required',
						
					},*/
						
					messages : {
						'entidad' : 'Debe ingresar el nombre',
					},
					submitHandler : function(form) {
						mensaje_consola('El formulario ha sido validado correctamente!');
					}
				});

	}

}