
var centerlat  = -12.094518;
var centerlong = -77.034901;
var zoom = 10;
var map = null;
var url = null;

$(function() { 
	url = $("#rurl").val();
	initialize();	
	eventosListadoGeocalizacion();	
});

function eventosListadoGeocalizacion(){
	eventosListadoGeocalizacion();	
}

function eventosListadoGeocalizacion(){
	var lstGeolocalizacion = $("#lstGeolocalizacion");
	var ps = lstGeolocalizacion.find("p");
	if(ps.length > 0){
		ps.click( function() {
			var inputId = $(this).find("input[type=hidden]").val();
			listarPuntosGeolocalizacion(inputId);
		});
	}
}

function listarPuntosGeolocalizacion(inputId){
	
	console.log( " inputId :" + inputId);
	
	var lstPuntosGeolocalizacion = $("#lstPuntosGeolocalizacion");	
	var u = url + "geolocalizacion/obtenerPuntosGeolocalizacion?id="+inputId;
	var h = "";
	$.get( u  , function(resp){
		$(resp).each( function( i , item ){
			h += "<p> latitud : "+item.latitud+" longitud : "+item.longitud+"  <input type='hidden' value='"+item.id+"'> </p>";
		});
		lstPuntosGeolocalizacion.html(h);
		eventosListadoGeocalizacion(lstPuntosGeolocalizacion);
	});
	
}

function eventosListadoGeocalizacion(lstPuntosGeolocalizacion){
	
	var ps = lstPuntosGeolocalizacion.find("p");
	if(ps.length > 0){
		ps.click( function() {
			var inputId = $(this).find("input[type=hidden]").val();
			// falta metodo para ubicarme en el mapa
			console.log(inputId);
		});
	}
	
}

function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(centerlat,centerlong),
      zoom: zoom,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
  }
