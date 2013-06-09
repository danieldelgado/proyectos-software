<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCj0iuD98oHnJcd1XxFmwdluF7Uxv4GZos&sensor=true">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.8.3.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.min.js" ></c:url>"></script>
</head>
<body>
	<h1>GeoLocalizacion Mapa</h1>

	<div>
		<div>


			<div>

				<fieldset>
					<legend> Datos Personales </legend>
					<div>
						<p>
							<label>Nombres completo:</label> <label> </label>
						</p>
						<p>
							<label>Apellidos completo:</label> <label> </label>
						</p>
						<p>
							<label>Telefono:</label> <label> </label>
						</p>
					</div>

				</fieldset>

			</div>
			<div>
				<p>Geolocalización</p>


			</div>
			<div></div>
		</div>
		<div>
			<div id="map_canvas" style="width: 300px; height: 300px"></div>
		</div>
	</div>

</body>

<script type="text/javascript"
	src="<c:url value="/resources/js/geoMap.js" ></c:url>"></script>

</html>