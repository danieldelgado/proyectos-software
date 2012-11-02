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

<P> login  <a href="principal">home</a></P>

<form action="login/iniciarSession" method="post">
<p> <label>Usuario : </label> <input type="text" id="usuario" name="usuario" value="admin1" />  </p>
<p> <label>Perfil : </label> 
<select name="perfil" id="perfil" > 
	<option selected="selected" value="-1" > Seleccione  </option> 
	<c:forEach items="${perfiles}" var="p" >
		<option selected="selected" value="${p.id}" >${p.nombre}</option>
	</c:forEach>
</select> </p>
<p> <label>Clave : </label> <input type="password" id="clave" name="clave"  value="123456" />  </p>
<p> <input type="submit" value="Ingresar"  /> </p>
</form>


</body>
</html>
