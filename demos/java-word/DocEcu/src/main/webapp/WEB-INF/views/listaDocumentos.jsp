<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link rel="stylesheet"	href="<c:url value="/resources/css/smoothness/jquery-ui-1.8.13.custom.css" ></c:url>"	type="text/css" media="screen" charset="utf-8">
<script src="<c:url value="/resources/js/jquery-1.6.1.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
<script	src="<c:url value="/resources/js/jquery-ui-1.8.13.custom.min.js" ></c:url>"	type="text/javascript" charset="utf-8"></script>
</head>
<script type="text/javascript">	
</script>
<body>
	<fieldset>
		<legend>Lista de Proyectos</legend>
		<div>		
			<div>
			<p><label>Titulo:</label> <label>${proyecto.titulo}</label> </p>
			<p><label>Folder:</label> <label>${proyecto.folder}</label> </p>
			<p><label>Ruta Absoluta</label> <label>${proyecto.ruta_Absoluta}</label> </p>
			<br>
			</div>		
			<div>			
				<table>
				  <tr>
				    <th>Nombre</th>
				    <th>uuid</th>				   
				  </tr>
					<c:forEach items="${proyecto.documentos}" var="d" >					 
					    <td>${d.titulo}</td>
					    <td>${d.uuid}</td>
					</c:forEach>
				</table>				
<%-- 				<a href="<c:url value="/nuevoProyecto" ></c:url>" >Crear Nuevo Proyecto</a> --%>
			</div>
		</div>	
	</fieldset>
</body>
</html>