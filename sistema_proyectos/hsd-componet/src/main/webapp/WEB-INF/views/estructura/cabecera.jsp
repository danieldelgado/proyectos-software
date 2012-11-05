<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>${titulo}</title>
	
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
	<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
	<link href="<c:url value="/resources/css/ui-lightness/ui.jqgrid.css"></c:url>" rel="stylesheet">
	<c:forEach var="css" items="${estilo}">
		<link rel="stylesheet" href="<c:url value="${css}" />" type="text/css" />
	</c:forEach>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/hsd-componet.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>" ></script> 
	<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.js" ></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.min.js" ></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ajaxupload.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/i18n/grid.locale-es.js" ></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.jqGrid.min.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.jqGrid.src.js" ></c:url>" ></script>
	<c:forEach var="js" items="${javascript}">
		<script type="text/javascript" src="<c:url value="${js}" />"></script>
	</c:forEach>	
		
	<script type="text/javascript">
	$(document).ready(function () {
		$('body').layout({ applyDefaultStyles: true });
	});
	</script>	
	
</head>
<body>

<INPUT type="hidden"  id="context"   value="<c:url value="/"></c:url>"/>

<DIV  class="ui-layout-north" >Cabecera</DIV>
<DIV class="ui-layout-west">
<jsp:include page="menu.jsp" />
</DIV>
<DIV class="ui-layout-center">
	