
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
<script type="text/javascript"> 
/*var infowindow;
var map;
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
  }*/
  
  function Pager(tableName, itemsPerPage) { 
	  this.tableName = tableName; 
	  this.itemsPerPage = itemsPerPage; 
	  this.currentPage = 1; 
	  this.pages = 0; 
	  this.inited = false; 

	  this.showRecords = function(from, to) { 
	  var rows = document.getElementById(tableName).rows; 
	  // i starts from 1 to skip table header row 
	  for (var i = 1; i < rows.length; i++) { 
	  if (i < from || i > to) 
	  rows[i].style.display = 'none'; 
	  else 
	  rows[i].style.display = ''; 
	  } 
	  } 

	  this.showPage = function(pageNumber) { 
	  if (! this.inited) { 
	  alert("not inited"); 
	  return; 
	  } 

	  var oldPageAnchor = document.getElementById('pg'+this.currentPage); 
	  oldPageAnchor.className = 'pg-normal'; 

	  this.currentPage = pageNumber; 
	  var newPageAnchor = document.getElementById('pg'+this.currentPage); 
	  newPageAnchor.className = 'pg-selected'; 

	  var from = (pageNumber - 1) * itemsPerPage + 1; 
	  var to = from + itemsPerPage - 1; 
	  this.showRecords(from, to); 
	  } 

	  this.prev = function() { 
	  if (this.currentPage > 1) 
	  this.showPage(this.currentPage - 1); 
	  } 

	  this.next = function() { 
	  if (this.currentPage < this.pages) { 
	  this.showPage(this.currentPage + 1); 
	  } 
	  } 

	  this.init = function() { 
	  var rows = document.getElementById(tableName).rows; 
	  var records = (rows.length - 1); 
	  this.pages = Math.ceil(records / itemsPerPage); 
	  this.inited = true; 
	  } 

	  this.showPageNav = function(pagerName, positionId) { 
	  if (! this.inited) { 
	  alert("not inited"); 
	  return; 
	  } 
	  var element = document.getElementById(positionId); 

	  var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> &#171 </span> Blogroll'; 
	  for (var page = 1; page <= this.pages; page++) 
	  pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');"></span> '; 
	  pagerHtml += '<span onclick="'+pagerName+'.next();" class="pg-normal"> »</span>'; 

	  element.innerHTML = pagerHtml; 
	  } 
	  } 
  //initialize()
</script> 
</head> 
<body onload=""> 
  <h1>Google Maps Api 3.0 - Marker clearing Sample</h1>
  <div id="map_canvas" style="width:70%; height:350px"></div> 
  <button onclick="map.clearMarkers();">clear</button>
  
dsaddadad
<br>
<br>
<br>
<br>
sadasdasdasd

<form action="" method="get" enctype="application/x-www-form-urlencoded"> 
<table id="results"> 
<tr> 
<th>#</th> 
<th>field</th> 
</tr> 
<tr> 
<td>1</td> 
<td><input type="text" name="field-name" value="rec1"></td> 
</tr> 
<tr> 
<td>2</td> 
<td><input type="text" name="field-name" value="rec2"></td> 
</tr> 
<tr> 
<td>3</td> 
<td><input type="text" name="field-name" value="rec3"></td> 
</tr> 
<tr> 
<td>4</td> 
<td><input type="text" name="field-name" value="rec4"></td> 
</tr> 
<tr> 
<td>5</td> 
<td><input type="text" name="field-name" value="rec5"></td> 
</tr> 
<tr> 
<td>6</td> 
<td><input type="text" name="field-name" value="rec6"></td> 
</tr> 
<tr> 
<td>7</td> 
<td><input type="text" name="field-name" value="rec7"></td> 
</tr> 
<tr> 
<td>8</td> 
<td><input type="text" name="field-name" value="rec8"></td> 
</tr> 
<tr> 
<td>9</td> 
<td><input type="text" name="field-name" value="rec9"></td> 
</tr> 
<tr> 
<td>10</td> 
<td><input type="text" name="field-name" value="rec10"></td> 
</tr> 
</table> 
<div id="pageNavPosition"></div> 
<div><input type="submit" onClick="alert('Hey, this is just a sample!'); return false;" />&nbsp;<input type="reset" /></div> 
</form> 

<script type="text/javascript"><!-- 
var pager = new Pager('results', 5); 
pager.init(); 
pager.showPageNav('pager', 'pageNavPosition'); 
pager.showPage(1); 
//-->
</script> 
  
  
