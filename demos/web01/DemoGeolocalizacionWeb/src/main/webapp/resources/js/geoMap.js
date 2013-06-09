
var centerlat  = -12.094518;
var centerlong = -77.034901;
var zoom = 10;

$(function() { 
	initialize();
});


function initialize() {
    var mapOptions = {
      center: new google.maps.LatLng(centerlat,centerlong),
      zoom: zoom,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
  }
