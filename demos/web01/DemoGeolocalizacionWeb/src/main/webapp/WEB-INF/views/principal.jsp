<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>GeoLocalizacion</h1>	
	<form action="<c:url value="principal/validarNumero"></c:url>" method="post">
		<p>Ingrese su numero de Celular:</p>
		<p>
			<input type="text" value="" name="numero" id="numero" />
		</p>
		<p>
			<input type="hidden" value="${msjError}" name="msjError" />
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
</body>
</html>
