<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>" ></script> 
	
	<script type="text/javascript">

	$(document).ready(function () {
		$('body').layout({ applyDefaultStyles: true });
	});

	</script>
		
	
</head>
<body>

<DIV class="ui-layout-center">Center
	content
</DIV>
<DIV  class="ui-layout-north" >Cabecera</DIV>
<DIV class="ui-layout-west">menu</DIV>
<DIV class="ui-layout-south" >pie</DIV>
	


</body>
</html>
