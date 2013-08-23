<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Registrando Usuario  
</h1>
	<form name='form' method='POST' action='registrarUsuario'>
		<input type="text" name="usuario.id" value="" />
		<input type="text" name="usuario.userName" value="" />
		<input type="text" name="usuario.clave" value="" />
		<input type="text" name="usuario.nombre" value="" />
		<input type="text" name="usuario.apellido" value="" />
		<input type="text" name="usuario.numeromovil" value="" />
		<input type='submit' value='Guardar' />
	</form>
</body>
</html>
