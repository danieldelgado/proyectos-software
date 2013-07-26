<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> -->
<%-- <link type="text/css"	href="<c:url value="resources/css/chatPanel.css" ></c:url>"	rel="stylesheet" /> --%>
<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.3.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.min.js" ></c:url>"></script>

<%-- <script type="text/javascript"	src="<c:url value="resources/js/functionClientChat.js?2033"></c:url>"></script> --%>
<title>Panel Chat Usuario</title>
</head>
<script type="text/javascript">
	$(function() {
		
		var ws = null, wsURI = null;
		var spTituloStatus = $("#spTitulo");
		var pnlChat = $("#pnlChat");
		var conversaciones = $("#conversaciones");
		var usuario = $("#txtUsuario");	
		var urlChat = $('#urlChat').val();
		var nombre_usuario = $("#nombre_usuario");
		
		initPanelBotonesConexion();
		initConexion(urlChat);
		
		function initPanelBotonesConexion(){
			$(pnlChat).hide();
			$("#btnActivado").click(function (){				
				$(pnlChat).show("drop", {direction : "right"}, 500, function() {
				});
			}).button();

			$("#btnDesactivado").click(function (){
				$(pnlChat).hide("drop", {direction : "right"}, 500, function() {
				});
			}).button();

			$("#btnConectado").click(function (){
				conexionChat();
			}).button();

			$("#btnDesconectar").click(function (){
				disconnect();
			}).button();			
		}

		function initConexion(url) {
			url =  location.host + urlChat ;
			wsURI = "ws://" + url + "chat";	
			$(conversaciones).accordion();
		}
		
		function reiniciarAcordionConversaciones(){
			try {
				$(conversaciones).accordion('destroy');				
			} catch (e) {
				console.log("catch");
				console.log(e);
			}
			
			$(conversaciones).accordion({
				collapsible: true
			});
		}

		function cambioestadoConectado(conectado) {
			if (conectado) {
				spTituloStatus.attr("class", " titulo connected ");
			} else {
				spTituloStatus.attr("class", " titulo disconnected ");
			}
		}
	
		function conexionChat(){
			var userName  = $(usuario).val();
			if (!userName || userName == '') {
				return;
			}
			if ('WebSocket' in window) {
				ws = new WebSocket(wsURI + '?userName=' + userName);
			} else if ('MozWebSocket' in window) {
				ws = new MozWebSocket(wsURI + '?userName=' + userName);
			} else {
				alert('Tu navegador no soporta WebSockets');
				return;
			}		
			ws.onopen = function() {
				setConnected(true);
			};
			ws.onmessage = function(event) {
				var message = JSON.parse(event.data);
				processMessage(message);
			};
			ws.onclose = function() {
 				disconnect();
			};
		}
		

		function processMessage(message) {
			console.log("message");
			console.log(message);
			if (message.messageInfo) {
//				showConversation(message.messageInfo.from);
//				addMessage(message.messageInfo.from, message.messageInfo.message, cleanWhitespaces(message.messageInfo.from) + 'conversation');
			} else if (message.statusInfo) {
				console.log(" message.statusInfo ");
				console.log(message.statusInfo);
				if (message.statusInfo.status == 'CONNECTED') {
					addOnlineUsuario(message.statusInfo.user);
					reiniciarAcordionConversaciones();
				} else if (message.statusInfo.status == 'DISCONNECTED') {
					removeConversacion(message.statusInfo.user);
// 					reiniciarAcordionConversaciones();
				}
			} else if (message.connectionInfo) {
				var activeUsers = message.connectionInfo.activeUsers;			
				if(activeUsers != null && activeUsers.length >0){
					for ( var i = 0; i < activeUsers.length; i++) {
						addOnlineUsuario(activeUsers[i]);
					}
					reiniciarAcordionConversaciones();
				}				
			}
		}
		
		
		
		function disconnect() {
			if (ws != null) {
				ws.close();
				ws = null;
			}
			setConnected(false);
		}
		
		function setConnected(connected) {
			reiniciarAcordionConversaciones();
			cleanConnectedUsers();	
			estado_conectado(connected);		
			if (connected) {
//				updateUserConnected();
			} else {
//				updateUserDisconnected();
			}
		}
		
		function estado_conectado(v){
			if(v){		
				cambioestadoConectado(v);//conectado
				$("#btnDesconectar").css({
					visibility : 'visible'
				});	
				$("#btnConectado").css({
					visibility : 'hidden'
				});	
				$(nombre_usuario).val($(usuario).val());
			}else{
				cambioestadoConectado(v);//desconectado
				$("#btnDesconectar").css({
					visibility : 'hidden'
				});	
				$("#btnConectado").css({
					visibility : 'visible'
				});	
				$(nombre_usuario).val("");
			}
		}
		
		function cleanConnectedUsers() {
			console.log("cleanConnectedUsers");
			console.log($(conversaciones));
			$(conversaciones).html("");
			console.log($(conversaciones));
		}
		
		function addOnlineUsuario(usuario){	
			$(conversaciones)
			.append('<h3 id="'+usuario+'"><a href="#">'+usuario+'</a></h3><div id="conversacion'+usuario+'+"><p>prueba</p></div>')
		}
		
		function removeConversacion(usuario) {	
			$(conversaciones).accordion('destroy');		
			$(conversaciones,  $("#"+usuario)).remove();
			$(conversaciones, $("#conversacion"+usuario) ).remove();
			$(conversaciones).accordion({
				collapsible: true
			});
		}
		
		function cleanWhitespaces(text) {
			return text.replace(/\s/g, "_");
		}
		
	});
</script>
<style>

#pnlChat {
	border: 1px solid;
	position: fixed;
	top: 10px;
	right: 0px;
	z-index: 100;
	float: right;
	margin: 0px;
	display: block;
	bottom: 0px;
	width: 250px;
}

span.titulo {
	right: 0px;
	padding: 0px;
	padding-top: 2px;
	margin-bottom: 5px;
	padding-left: 20px;
}

disconnected {
	background: url('../resources/img/disconnected.png') no-repeat left;
	padding-right: 20px;
}

connected {
	background: url('../resources/img/connected.png') no-repeat left;
	padding-right: 20px;
}

#cabeceraChat{
	padding: 0px;
	padding-bottom: 5px;
	border-bottom: 1px solid;
/* 	color: white; */
/* 	background-color: black; */
}

#conversaciones{
	overflow-y: auto;
}
</style>
<body>

	<input type="hidden" value="<c:url value="/" ></c:url>" id="urlChat">
	
	<div id="pnlChat">
		<div id="cabeceraChat">
			<span id="spTitulo" class="disconnected titulo">Chat Usuario :</span>
			<span id="nombre_usuario"></span>			
			<img id="btnDesconectar" alt="arrow_posts_left" src="<c:url value="/resources/img/arrow_posts_left.png" ></c:url>">
		</div>
		<div id="lista_conversaciones">
			<div id="conversaciones">
			</div>	
		</div>
	</div>
	
	<div id="initConexion" style="height: 1500px; width: 50%;">
		<fieldset>
			<legend>Botones</legend>
			<div>
				<button id="btnActivado">Chat Panel Activada</button>
				<br>
				<button id="btnDesactivado">Chat Panel Desactivado</button>
				<br> <input id="txtUsuario" type="text" value=""> <br>
				<button id="btnConectado">Chat Conexion</button>
				<br>
			</div>
		</fieldset>
	</div>
	
</body>
</html>