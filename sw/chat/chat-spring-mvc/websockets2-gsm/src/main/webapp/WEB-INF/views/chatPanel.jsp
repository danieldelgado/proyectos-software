<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link type="text/css"
	href="<c:url value="resources/css/chatPanel.css" ></c:url>"
	rel="stylesheet" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript"
	src="<c:url value="resources/js/functionClientChat.js?2033"></c:url>"></script>
<title>chat panel</title>
</head>

<body>
	<input type="hidden" value="<c:url value="/" ></c:url>" id="urlChat">
	<div class="togglerPanel">
			<div id="effectPanel" class="ui-widget-content ui-corner-all">
			<div>				
				<h3 class="ui-widget-header ui-corner-all">Chat <span id="estadoConexion" style="width: 10px;" > __ </span> </h3>
			</div>	
			<div>
				<button id="btnDesconectar" >Desconectar</button>
			</div>		
			<div id="lstusuarioChatPanel">
				<br>
			</div>
		</div>
	</div>
	<a href="#" id="btnAparece" class="ui-state-default ui-corner-all">Aparece
		Run Effect</a>
	<a href="#" id="btnDesaparece" class="ui-state-default ui-corner-all">Desaparece
		Run Effect</a>
	<div>
		<p>
			<label>Usuario:</label> <input type="text" id="usuario" value="" />
		</p>
	</div>
	<a href="#" id="btnConectarmeChat"
		class="ui-state-default ui-corner-all">Conectarme</a>
	<div style="height: 1500px"></div>
	<div id="dialogChat"></div>
</body>
</html>