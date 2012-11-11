var formulario;
var form = null;
var idcontent = "";

$(function() {
	formulario = $(".formulario "+idcontent);
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