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
				<table>
				  <tr>
				    <th>Titulo</th>
				    <th>Folder</th>
				    <th>Ruta_completa</th>
				    <th>Path</th>
				    <th>Uuid</th>
				    <th>Address</th>
				    <th>Scheme</th>
				    <th>Acceder Proyecto</th>
				  </tr>
					<c:forEach items="${listarProyectos}" var="py" >
					  <tr>
					    <td>${py.titulo}</td>
					    <td>${py.folder}</td>
					    <td>${py.ruta_padre}</td>
					    <td>${py.ruta_Absoluta}</td>
					    <td>${py.uuid}</td>
					    <td>${py.address}</td>
					    <td>${py.scheme}</td>
					    <td><a href=" <c:url value="/Proyecto/${py.titulo}/${py.id}" ></c:url>" >${py.titulo}</a></td>
					   
					  </tr>
					</c:forEach>
				</table>
				
				<a href="<c:url value="/nuevoProyecto" ></c:url>" >Crear Nuevo Proyecto</a>
			</div>
		</div>
	
	</fieldset>


</body>
</html>