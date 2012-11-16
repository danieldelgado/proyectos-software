
var formulario = null;
var qS = "";

$(function() {
	
	formulario = $("#fmsj");
	obtenerUrlPOST();	
	formulario.attr("action",formulario.attr("action")+qS );

	$("#btnContactenme").click(function(){	
		formulario.submit();
	});
		
});


function obtenerUrlPOST(){
		if(document.location.href.indexOf('?')!=-1){
			qS = document.location.href.substring(document.location.href.indexOf('?'));
		}
}
