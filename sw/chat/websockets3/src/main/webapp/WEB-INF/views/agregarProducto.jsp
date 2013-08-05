<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        
    <link type="text/css" href="<c:url value="resources/css/default.css?123" ></c:url>" rel="stylesheet" />
    <link type="text/css" href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/stomp.js"></c:url>"></script>
<%--     <script type="text/javascript" src="<c:url value="resources/js/agregarProducto.js"></c:url>"></script> --%>
    <title> Websockets y Tomcat 7</title>
   
</head>

<script type="text/javascript">



</script>
<body>
<div>
	<fieldset>	
		<legend>Agregar Producto</legend>
		<br/>		
		<br/>			
		<form action="<c:url value="/guardarProducto" />" method="post" >
			<input type="text" name="nombre" ><br/>
			<input type="text" name="precio" ><br/>
			<input type="text" name="fechaRegistro" >
			<input type="submit" value="enviar" >
		</form>						
	</fieldset>
</div>
</body>
</html>