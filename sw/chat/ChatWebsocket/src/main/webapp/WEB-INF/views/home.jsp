<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>
<fieldset>
<legend>Incion de Session</legend>

<form action="<c:url value="/iniciarSession" ></c:url>" method="POST">
	<p><label>Usuario</label> <input type="text" value="chat01" name="usuario" > </p>
	<p><label>Clave</label> <input type="text" value="1234" name="clave" > </p>
	<p> <input type="submit" value="Iniciar" > </p>
</form>
</fieldset>
</div>


</body>
</html>
