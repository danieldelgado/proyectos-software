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
				    <th>Numero</th>	
				    <th>Opciones</th>				   
				  </tr>
					<c:forEach items="${proyecto.seccion_Documentos}" var="sd" >	
					<tr>				 
					    <td> <label>${sd.nombre} </label> </td>
					    <td> <label>${sd.numero} </label> </td>					    
					    <td>
					    <p> 
					     &nbsp;
					    <a href="<c:url value="/Proyecto/${proyecto.folder}/${proyecto.id}/nuevaSubSeccionDocumento/${sd.id}" ></c:url>" > Crear Sub Seccion </a>
					    &nbsp;					   
					    <a href="<c:url value="/Proyecto/${proyecto.folder}/${proyecto.id}/crearContenido/${sd.id}" ></c:url>" > Crear Contenido </a>  </p>
					     &nbsp;
					    </td>				    
					     </tr>
					</c:forEach>
				</table>				
				<a href="<c:url value="/Proyecto/${proyecto.folder}/${proyecto.id}/nuevaSeccion" ></c:url>" >Crear Nueva Seccion</a>
			</div>
		</div>	
	</fieldset>
</body>
</html>