var formulario;
var form = null;
var idcontent = "";

$(function() {
	formulario = $(".formulario "+idcontent);
	
	 $.ajax({
	        type : "get",
	        url: context+"valacion/parametros/Parametro",
	        async:  false,
	        dataType :"json",
	        success:  function (msg) {
	           mensaje_consola(msg);
	        }
	    });
	
	cargarValidateForm();
	
	$(".clGuardar").button().click(function() {
		formulario.submit();
	});
	
});

function cargarValidateForm() {
	if (formulario != null) {
		formulario.validate({
					debug : true,
					rules : {
						'entidad' : 'required',
					},
					messages : {
						'entidad' : 'Debe ingresar el nombre',
					},
					submitHandler : function(form) {
						mensaje_consola('El formulario ha sido validado correctamente!');
					}
				});

	}

}