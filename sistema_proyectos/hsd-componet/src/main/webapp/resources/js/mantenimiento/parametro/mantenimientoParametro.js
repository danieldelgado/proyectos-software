
$(function() {
	 cargarParametrosPadre();
});


function cargarParametrosPadre(){
		
    $( "ul.droptrue" ).sortable({
        connectWith: "ul",
        update: function(event, ui) {
			console.log("update");
			console.log(ui);
			console.log(event);
				
			},
    	activate: function( event, ui ){
			console.log("activate");
    		console.log(ui);
			console.log(event);
    	},
    	receive: function( event, ui ){
			console.log("receive");
    		console.log(ui);
			console.log(event);
    	},
    	over: function( event, ui ){
			console.log("over");
    		console.log(ui);
			console.log(event);
    	},
    	out: function( event, ui ){
			console.log("out");
    		console.log(ui);
			console.log(event);
    	},
    	beforeStop: function( event, ui ){
			console.log("beforeStop");
    		console.log(ui);
			console.log(event);
    	},
      //  dropOnEmpty: false
    });

    $( ".droptrue" ).disableSelection();
    
    
	
}




