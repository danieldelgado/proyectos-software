$(function() {
	cargarBotones();
	cargarAutoCompĺete();

});

function cargarBotones() {
	
	  $("#btnGuardarParametroPorParametro").button().click(  function() {
	    	var d = $(this).parent();
			var codigo = d.find(".codigo").val();
			var icono = d.find(".icono").val();
			var onComplete = d.find(".onComplete").val();
			var onSubmit = d.find(".onSubmit").val();
			var parametrosJson = d.find(".parametrosJson").val();
			var tipo = d.find(".tipo").val();
			var url = d.find(".url").val();
			var descripcion = d.find(".descripcion").val();
			
			mensaje_consola(" manParaPara ");
			
		});
	
	
}

function cargarAutoCompĺete() {

	ajaxAsyncGet(context + "mantenimiento/parametro/obtenerListaParametros",
			null, function(data) {
				var procesos = new Array();
				for ( var i = 0; i < data.length; i++) {
					procesos[i] = {
						id : data[i].id,
						label : data[i].nombre
					};
				}

				$(".autoComplete").autocomplete({
					source : procesos,
					select : function(event, ui) {
						var idSelect = ui.item.id;
						mensaje_consola(idSelect);
					}
				});

			});

}
