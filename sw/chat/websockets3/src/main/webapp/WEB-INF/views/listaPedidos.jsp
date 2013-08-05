<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        
    <link type="text/css" href="<c:url value="resources/css/default.css?123" ></c:url>" rel="stylesheet" />
    <link type="text/css" href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/stomp.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/relistar.js"></c:url>"></script>
    <title> Websockets y Tomcat 7</title>
   
</head>

<script type="text/javascript">



</script>
<body>
<div>
	<fieldset>	
		<legend>Lista</legend>
		<br/>		
		<br/>		
		<table id="divtabla" >
		  <tr>
		    <th>Column id Heading</th>
		    <th>Column nombre Heading</th>
		    <th>Column precio Heading</th>
		    <th>Column fechaRegistro Heading</th>
		  </tr>		  
		  <c:forEach items="${lstBD}" var="bd" > 		  
			  <tr id="divRow${bd.id}">
			    <td>${bd.id}</td>
			    <td>${bd.nombre}</td>
			    <td>${bd.precio}</td>
			    <td>${bd.fechaRegistro}</td>
			  </tr>		  
		  </c:forEach>	
		</table>		
	</fieldset>
</div>
</body>
</html>