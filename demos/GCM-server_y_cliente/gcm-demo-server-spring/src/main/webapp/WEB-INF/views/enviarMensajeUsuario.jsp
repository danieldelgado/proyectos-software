<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h2>Enviar Mensaje a Usuario</h2>	
	<form name='form' method='POST' action='<c:url value="/enviarMensaje/${usuario.id}" ></c:url>'>
		<input type="text" name="mensaje" value="holaaa" />
		<input type='submit' value='Send Message' />
	</form>
<a href="<c:url value="/listarUsuarios" ></c:url>" >Listar Usuarios</a>

</body>
</html>
