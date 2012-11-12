
var asignados = null;
var disponibles = null;

$(function() {
	 cargarParametrosPadre();
	 console.log(context+"dwr");
	 validateServiceDWR._path = '/hsd-componet/dwr';
});


function cargarParametrosPadre(){		
	
	validateServiceDWR.obtenerParametrosRulesEntidad("Parametro",function(resp) {
		mensaje_consola(resp);		
	});	
	
    $( "ul.droptrue" ).sortable({
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
}
