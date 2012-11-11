<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="contentTag${ent}" class="contentTag">
	<c:forEach items="${estiloConent}" var="css">
		<script type="text/javascript" src="<c:url value="${css}" ></c:url>"></script>
	</c:forEach>

	<c:forEach items="${javascriptConent}" var="js">
		<script type="text/javascript" src="<c:url value="${js}" ></c:url>"></script>
	</c:forEach>


	<c:if test="${dwr}">
		<script type='text/javascript'
			src="<c:url value="/resources/js/engine.js" ></c:url>"></script>
		<script type='text/javascript'
			src="<c:url value="/dwr/util.js" ></c:url>"></script>
		<c:forEach items="${methodDWR}" var="d">
			<script type="text/javascript" src="<c:url value="${d}" ></c:url>"></script>
		</c:forEach>
		
		
		
		<script type="text/javascript">	
		
			dwrService._path = '<c:url value="/dwr" ></c:url>';//'/hsd-componet/dwr';
			/*	dwrService.add(3, 4, parseResult);
			function parseResult(data) {
				console.log("data:"+data);
			}
			 */
		</script>
	</c:if>
	
	<input type="hidden" id="idcontent" class="idcontent"  value="" />