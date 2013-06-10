var centerlat = -12.094518;
var centerlong = -77.034901;
var zoom = 10;
var map = null;
var url = null;
var markersArray = [];

$(function() {
	url = $("#rurl").val();
	initialize();
	eventosListadoGeocalizacion();
});

function eventosListadoGeocalizacion() {
	eventosListadoGeocalizacion();
}

function eventosListadoGeocalizacion() {
	var lstGeolocalizacion = $("#lstGeolocalizacion");
	var ps = lstGeolocalizacion.find("p");
	if (ps.length > 0) {
		ps.click(function() {
			var inputId = $(this).find("input[type=hidden]").val();
			listarPuntosGeolocalizacion(inputId);
		});
	}
}

function listarPuntosGeolocalizacion(inputId) {
	var lstPuntosGeolocalizacion = $("#lstPuntosGeolocalizacion");
	var u = url + "geolocalizacion/obtenerPuntosGeolocalizacion?id=" + inputId;
	var h = "";
	var marker = null;
	clearOverlays();
	$.get(u, function(resp) {
		$(resp).each(
				function(i, item) {
					h += "<p> latitud : " + item.latitud + " longitud : "
							+ item.longitud + "  <input type='hidden' value='"
							+ item.id + "'> </p>";
					
					
					marker = new google.maps.Marker({
						position : new google.maps.LatLng(item.latitud, item.longitud),
						map : map
					});
					markersArray.push(marker);
					
				});
		lstPuntosGeolocalizacion.html(h);
	});

}

function clearOverlays() {
	if (markersArray) {
		for (i in markersArray) {
			markersArray[i].setMap(null);
		}
	}
}

function initialize() {
	var mapOptions = {
		center : new google.maps.LatLng(centerlat, centerlong),
		zoom : zoom,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
}
