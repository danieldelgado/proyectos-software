//http://www.pittss.lv/jquery/gomap/solutions.php

var centerlat  = -12.094518;
var centerlong = -77.034901;
var zoom = 10;

$(function() { 
	$("#gmap").gmap3();
	$("#gmap").gmap3({action:'addMarker', name:'marker', address: "paris", tag : "mytag-paris"});

});



