<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>GeoLocalizacion Registrar Numero</h1>
	<form action="<c:url value="/geolocalizacion/registrarUsuarioTelefono"></c:url>" method="POST">
		<p> <label>Nombre Completo:</label> <input type="text" value="" name="nombresCompleto" id="nombresCompleto" /></p>
		<p> <label>Apellidos Completo:</label> <input type="text" value="" name="apellidosCompletos" id="apellidosCompletos" /></p>
		<p> <label>Fecha de Nacimiento:</label> <input type="text" value="" name="fechaNacimiento" id="fechaNacimiento" /></p>
		<p> <label>Numero:</label> <input type="text" value="" name="numero" id="numero" /></p>	
		<p> <label>Tipo Numero:</label> <input type="text" value="" name="tipoTelefono" id="tipoTelefono" /></p>	
		<c:if test="${mensaje != null }">	
			<p> ${mensaje} </p>
			<c:forEach items="${rst.errores}" var="e" >
			<p>${e}</p>
			</c:forEach>
		</c:if>  	
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<a href="<c:url value="/principal"></c:url>" >Ir a principal</a>
</body>
</html>