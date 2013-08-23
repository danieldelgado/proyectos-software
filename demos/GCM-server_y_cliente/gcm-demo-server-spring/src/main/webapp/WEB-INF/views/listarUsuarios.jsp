<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Lista de Usuarios</h1>
	<fieldset>
		<div>
			<table>
				<tr>
					<th>Nombre</th>
					<th>Usuario</th>
					<th>Enviar Mensaje</th>
				</tr>
				<c:forEach var="usu" items="${usuariosDevices}">
					<tr>
						<td>${usu.nombre}</td>
						<td>${usu.userName}</td>
						<td><a
							href="<c:url value="/enviarMensajeUsuario/${usu.id}" ></c:url>">Mensaje</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</fieldset>
</body>
</html>
