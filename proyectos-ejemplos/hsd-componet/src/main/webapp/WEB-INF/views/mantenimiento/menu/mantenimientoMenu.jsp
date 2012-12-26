<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p" %>
<p:html titulo="Mantenimiento de Menu" javascript="">

<html> 
<head> 
<meta name="viewport" content="initial-scale=1.0, user-scalable=no"> 
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
<script type="text/javascript"> 
  var infowindow;
  (function () {
    google.maps.Map.prototype.markers = new Array();
    google.maps.Map.prototype.getMarkers = function() {
      return this.markers
    };
    google.maps.Map.prototype.clearMarkers = function() {
      for(var i=0; i<this.markers.length; i++){
        this.markers[i].setMap(null);
      }
      this.markers = new Array();
    };
    google.maps.Marker.prototype._setMap = google.maps.Marker.prototype.setMap;
    google.maps.Marker.prototype.setMap = function(map) {
      if (map) {
        map.markers[map.markers.length] = this;
      }
      this._setMap(map);
    }
  })();
   
  function initialize() {
    var latlng = new google.maps.LatLng(28.517874444655206, -81.29196166992188);
    var myOptions = {
      zoom: 11,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.HYBRID
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    var myLatLng = new google.maps.LatLng(28.499171, -81.31254);
    var beachMarker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      title:"Home"
    });
   
    var myLatLng = new google.maps.LatLng(28.600478, -81.201373);
    var beachMarker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      title:"UCF (School)"
    });
   
    var myLatLng = new google.maps.LatLng(28.538385790782893, -81.37916564941406);
    var beachMarker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      title:"Orlando Downtown"
    });
  }
</script> 
</head> 
<body onload="initialize()"> 
  <h1>Google Maps Api 3.0 - Marker clearing Sample</h1>
  <div id="map_canvas" style="width:70%; height:350px"></div> 
  <button onclick="map.clearMarkers();">clear</button>
</body> 
</html>

</p:html>
