//http://www.pittss.lv/jquery/gomap/solutions.php

var centerlat  = -12.094518;
var centerlong = -77.034901;
var zoom = 6;

$(function() { 
    $("#gmap").goMap({
    		latitude:centerlat,
			longitude:centerlong,
			zoom: zoom
			}); 
});


