<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/smoothness/jquery-ui-1.8.13.custom.css" ></c:url>"
	type="text/css" media="screen" charset="utf-8">
<script src="<c:url value="/resources/js/jquery-1.6.1.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
<script
	src="<c:url value="/resources/js/jquery-ui-1.8.13.custom.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
</head>
<script type="text/javascript">
	
</script>
<body>

	<fieldset>
		<legend>Lista de Proyectos</legend>

		<div>
			<div>
				<form action="<c:url value="/guardarProyecto" ></c:url>" method="post" >
					<p>
						<label>Titulo</label> <input type="text" name="titulo" value="Reportador" >
					</p>
					<p>
						<label>Nombre del folder</label> <input type="text" name="folder" value="Reportador">
					</p>
					<p>
						<label>Descripcion</label> <input type="text" name="descripcion" value="Reportador">
					</p>
					<p> <input type="submit" value="Guardar Proyecto" > </p>
				</form>	
			</div>
		</div>

	</fieldset>


</body>
</html>
