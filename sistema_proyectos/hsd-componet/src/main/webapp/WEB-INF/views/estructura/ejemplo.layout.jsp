<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>" ></script> 
	<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.js" ></c:url>" ></script> 
	<script type="text/javascript">

	$(document).ready(function () {
		$('body').layout({ applyDefaultStyles: true });
	});

	</script>
		
	
</head>
<body>

	<DIV class="ui-layout-center">Center
	<P><A href="http://layout.jquery-dev.net/demos.html">Go to the Demos page</A></P>
	<P>* Pane-resizing is disabled because ui.draggable.js is not linked</P>
	<P>* Pane-animation is disabled because ui.effects.js is not linked</P>
</DIV>
<DIV class="ui-layout-north">North</DIV>
<DIV class="ui-layout-south">South</DIV>
<DIV class="ui-layout-east">



</DIV>
<DIV class="ui-layout-west">
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

</DIV>




	


</body>
</html>
