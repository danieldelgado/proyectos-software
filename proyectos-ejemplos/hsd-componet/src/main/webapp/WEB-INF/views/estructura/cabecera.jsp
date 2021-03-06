
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<html>
<head>
<title>${titulo}</title>
<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/resources/css/ui-lightness/ui.jqgrid.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css"></c:url>" rel="stylesheet">
<c:forEach var="css" items="${estilo}">
	<link rel="stylesheet" href="<c:url value="${css}" />" type="text/css" />
</c:forEach>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.3.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.min.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.min.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/layout/jquery.layout.resize.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/ajaxupload.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/i18n/grid.locale-es.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.jqGrid.min.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-validate.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/hsd-componet.js" ></c:url>"></script>
<c:forEach var="js" items="${javascript}">
	<script type="text/javascript" src="<c:url value="${js}" />"></script>
</c:forEach>
</head>
<body>
	<fmt:setLocale value="es_ES" />

	<input type="hidden" id="context" value="<c:url value="/"></c:url>" />
	<input type="hidden" id="consolemessage" value="${consolemessage}" />

	<div class="ui-layout-north">
		Cabecera :
		<fmt:message key="componet.cabecera.titulo"></fmt:message>
		<a href="<c:url value="/principal" ></c:url>" class="oplink"> Inicip </a>
		<br>
	<a href="<c:url value="login/terminarSession" ></c:url>" >Terminar Session</a>
		
		
	</div>
	<div class="ui-layout-west">
			<jsp:include page="menu.jsp" />		
	</div>
	<div id="tabs" class="ui-layout-center">