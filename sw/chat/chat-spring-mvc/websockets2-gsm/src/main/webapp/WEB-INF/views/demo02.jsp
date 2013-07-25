<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Ejemplo</title>
	<link type="text/css" href="<c:url value="resources/css/paneles2.css" ></c:url>" rel="stylesheet" />
    <link type="text/css" href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" rel="stylesheet" />
	<script type="text/javascript"	src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script>
	<script type="text/javascript"	src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="resources/js/jqPaneles.js"></c:url>"></script>
	
</head>
<body>
<a href="#" id="abre_tab">
    <div id="tab">
        <div id="tab_interna">
 
        </div>
    </div> 
</a>
<!-- Panel oculto -->
<div id="panel">
    <div class="contenido">
        <h3>Contenido</h3>
    </div>    
</div>
</body>
</html>