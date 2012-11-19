<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="contentTag${entidad}" class="contentTag">

	<input type="hidden" id="idcontent" class="idcontent"  value="${ent}" />
	<input type="hidden" id="entidad" class="entidad"  value="${entidad}" />

	<c:forEach items="${estiloConent}" var="css">
		<script type="text/javascript" src="<c:url value="${css}" ></c:url>"></script>
	</c:forEach>

	<c:forEach items="${javascriptConent}" var="js">
		<script type="text/javascript" src="<c:url value="${js}" ></c:url>"></script>
	</c:forEach>
	
	
	
	
	
