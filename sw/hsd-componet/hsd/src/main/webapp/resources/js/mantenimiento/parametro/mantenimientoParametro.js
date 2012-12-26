
var asignados = null;
var disponibles = null;

$(function() {
	 cargarParametrosPadre();
});

function cargarParametrosPadre(){		
	
    $( "ul.padresAsignacion" ).sortable({
        connectWith: "ul",
        change: function(event, ui) {			
        	var li = ui.item;
			li.addClass("active");
		}, 
		receive: function( event, ui ){			
        	var li = ui.item;
    		var asignados=$(".asignados");
    		var ulAsignados=asignados.find("ul");
    		var liAsignados = ulAsignados.find("li");
    		var disponibles=$(".disponibles");
    		var ulDisponibles=disponibles.find("ul");        	        	
        	if($(liAsignados).length>1){        		
        		$(liAsignados).removeClass("active");
        		$(ulDisponibles).append(liAsignados);
        		$(ulAsignados).html("");
        		$(ulAsignados).append(li);        		
        	}	  
    	}    	
    }).disableSelection();	
   

    $("#btnGuardarParametro").button().click(  function() {
    	var d = $(this).parent();
		var codigo = d.find(".codigo").val();
		var icono = d.find(".icono").val();
		var onComplete = d.find(".onComplete").val();
		var onSubmit = d.find(".onSubmit").val();
		var parametrosJson = d.find(".parametrosJson").val();
		var tipo = d.find(".tipo").val();
		var url = d.find(".url").val();
		var descripcion = d.find(".descripcion").val();
		
		
		
	});
    
    
    $("#btnAbrirDialogoParametrosAsignar").button().click(  function() {
    	var d = $(this).parent();
		var codigo = d.find(".codigo").val();
		var icono = d.find(".icono").val();
		var onComplete = d.find(".onComplete").val();
		var onSubmit = d.find(".onSubmit").val();
		var parametrosJson = d.find(".parametrosJson").val();
		var tipo = d.find(".tipo").val();
		var url = d.find(".url").val()+"?idparametro=0";
		var descripcion = d.find(".descripcion").val();
		
		openDialog(url,null);
    	
    	
	} );
    
}


