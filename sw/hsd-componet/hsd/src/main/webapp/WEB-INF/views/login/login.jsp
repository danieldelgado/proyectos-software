<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/resources/css/style.css" ></c:url>" ></script> 
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>" ></script> 
	<script type="text/javascript" src="<c:url value="/resources/js/login/login.js" ></c:url>" ></script> 
			
</head>
<body>

<form action="login/iniciarSession" method="post">
<p> <label>Usuario : </label> <input type="text" id="usuario" name="usuario" value="admin" />  </p>
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
