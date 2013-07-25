<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Ejemplo</title>

<!-- <link type="text/css" -->
<%-- 	href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" --%>
<!-- 	rel="stylesheet" /> -->
<!-- <script type="text/javascript" -->
<%-- 	src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script> --%>
<!-- <script type="text/javascript" -->
<%-- 	src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script> --%>


</head>
<style>
#example {
/* 	position: fixed; */
/* 	bottom: 0px; */
/* 	top: 10px; */
/* 	height: 97%; */
/* 	right: 0px; */
/* 	border: 1px solid; */
/* 	z-index: 100; */
/* 	width: : 100%; */
/* 	float: right; */
	margin: 0px;
  	border: 2px solid; 
/*  	border-radius: 10px;  */
/* 	width: 170px; */
/* 	display: block; */
}

.cabTitulo {
/* 	position: relative; */
/* 	display: block; */
}
</style>
<body>

	<div id="example">
		<h3 class="">Chat</h3>
		<div>
			<div class="cabTitulo">
				<div class="cerrarPanel">
				
				</div>
				<div class="titulo">					
					<p class="ui-corner-all">
						<span> <font>Usuario</font></span>
					</p>
				</div>
			</div>
			<div class="lista">
				<div class="usuarios_en_linea">
					<div class="user">
						<p>usuario 01</p>
					</div>
					<div class="user">
						<p>usuario 02</p>
					</div>
					<div class="user">
						<p>usuario 03</p>
					</div>
					<div class="user">
						<p>usuario 04</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 1500px"></div>


</body>
</html>