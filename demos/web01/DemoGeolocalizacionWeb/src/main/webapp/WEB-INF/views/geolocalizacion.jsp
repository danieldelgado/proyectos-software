<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Geolocalizacion</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.3.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.min.js" ></c:url>"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script type="text/javascript" src="<c:url value="/resources/js/gmap3.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/geoMap.js" ></c:url>"></script>
</head>
<style> 
#gmap { 
    width:700px; 
    height:400px; 
} 
</style> 
<body>
	<h1>GeoLocalizacion Mapa</h1>
	<div>
		<input type="text" name="numero" id="numero" value="">
		<div >
			<div id="gmap" >
				
			</div>
			<div id="divListaCoordenadas">
				
			</div>
		</div>
		<div>
			<a href="<c:url value="/"></c:url>" >Ir a principal</a>
		</div>
	</div>
</body>
</html>
