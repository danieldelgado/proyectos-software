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
 	<input type="hidden" id="rurl" value="<c:url value="/" ></c:url>">
	<div>
		<div>
			<div style="float: left; width: 30%; height: 100%;">
				<fieldset>
					<legend> Datos Personales </legend>
					<div>
						<p>
							<label>Nombres completo:</label> ${telefono.nombresCompleto } <label>
							</label>
						</p>
						<p>
							<label>Apellidos completo:</label> ${telefono.apellidosCompletos} <label> </label>
						</p>
						<p>
							<label>Telefono:</label> <label> ${telefono.numero } </label>
						</p>
					</div>
				</fieldset>
				<fieldset>
					<legend> Lista de Geolozalizaciones </legend>
					<div id="lstGeolocalizacion">
						<c:if test="${not empty lstGeolocalizacions}">
							<c:forEach items="${lstGeolocalizacions}" var="geo">
								<p>
									<label> ${geo.id} - ${geo.fechaRegistro} </label> <input
										type="hidden" value="${geo.id}">
								</p>
							</c:forEach>
						</c:if>
					</div>
				</fieldset>
			</div>
			<div style="float: left; width: 30%; height: 100%;">
				<fieldset>
					<legend> Puntos de Geolocalizacion </legend>
					<div id="lstPuntosGeolocalizacion">
						
					</div>
				</fieldset>
			</div>
			<div style="float: left; width: 40%;">
				<div id="map_canvas" style="width: 100%; height: 100%;"></div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<c:url value="/resources/js/geoMap.js" ></c:url>"></script>

</html>