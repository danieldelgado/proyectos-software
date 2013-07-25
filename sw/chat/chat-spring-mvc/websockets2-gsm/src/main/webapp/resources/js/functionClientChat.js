$(function() {
	var targetUserChat = null, usuarioChatTitulo = null, ws = null, wsURI = null;
	var dialog = $('#dialogChat');
	var lstusuarioChatPanel = $("#lstusuarioChatPanel");
	var usuario = $("#usuario");	
	var urlChat = $('#urlChat').val();
	
	iniChatPanel();
	connectionInstance(urlChat);
	
	function iniChatPanel(){
		$("#estadoConexion").attr("class","disconnected");
		$("#effectPanel").hide();
		$(dialog).dialog({
			autoOpen : false,
			buttons : {
				'Ok' : function() {
					closeChatMmensajePanel();
				}
			},
			height : 300,
			close : function(event, ui) {
				closeChatMmensajePanel();
			}
		});
		$("#btnAparece").click(function() {
			runEffectAparece();
			return false;
		});
		$("#btnDesaparece").click(function() {
			runEffectDesaparece();
			return false;
		});		
		$("#btnConectarmeChat").click(function() {
			connect($(usuario).val());
			return false;
		});		
		$("#btnDesconectar").click(function() {
			console.log("btnDesconectar");
			disconnect();
			estado_conectado(false);
			return false;
		}).button({
			icons : {
				primary : "ui-icon ui-icon-closethick"
			}
		}).css({
			visibility : 'hidden'
		});	
	}
	
	function runEffectAparece() {
		var selectedEffect = "drop";
		var options = {
			direction : "right"
		};
		$("#effectPanel").show(selectedEffect, options, 500, function() {
		});
	}
	


	function runEffectDesaparece() {
		var selectedEffect = "drop";
		var options = {
			direction : "right"
		};
		if ($(dialog).dialog("isOpen") == true) {
			$(dialog).dialog("close");
		}
		$("#effectPanel").hide(selectedEffect, options, 500, function() {
		});
	}	

	function closeChatMmensajePanel() {
		$(dialog).dialog('close');
	}

	function openChatMensajePanel(){
		$(dialog).dialog('open');
	}
	
	function connectionInstance(url){
		url =  location.host + url ;
		wsURI = "ws://" + url + "chat";
	}
	
	function connect(userName) {
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
	
	function estado_conectado(v){
		if(v){		
			$("#estadoConexion").attr("class","connected");//conectado
			$("#btnDesconectar").css({
				visibility : 'visible'
			});	
			$("#btnConectarmeChat").css({
				visibility : 'hidden'
			});	
		}else{
			$("#estadoConexion").attr("class","disconnected");//desconectado
			$("#btnDesconectar").css({
				visibility : 'hidden'
			});	
			$("#btnConectarmeChat").css({
				visibility : 'visible'
			});	
		}
	}
	
	function setConnected(connected) {
		estado_conectado(connected);
		cleanConnectedUsers();
		if (connected) {
//			updateUserConnected();
		} else {
//			updateUserDisconnected();
		}
	}
	
	function disconnect() {
		if (ws != null) {
			ws.close();
			ws = null;
		}
		setConnected(false);
	}
	
	function cleanConnectedUsers() {
		$(lstusuarioChatPanel).html("");
	}
	
	function addOnlineUsuario(usuario){	
		console.log("usuario:"+usuario);
		var  divChatUser = $(document.createElement('div'));
		divChatUser.attr("id",usuario+"user_chat");
		divChatUser.attr("class","user_chat");
		var pchatusuario = $(document.createElement('p'));
		var spanchatusuario = $(document.createElement('span'));
		spanchatusuario.html(usuario);	
		divChatUser.append(pchatusuario);
		pchatusuario.append(spanchatusuario);	
		lstusuarioChatPanel.append(divChatUser);	
		addEventDivChatUsuario(divChatUser);
	}
	
	function removeOnlineUsuario(usuario){
		$(lstusuarioChatPanel).each(function(index, elem) {
			if (elem.id == usuario+"user_chat") {
				$(elem).remove();
			}
		});
	}
	
	function addEventDivChatUsuario(divChatUser){
		$(divChatUser).click(function() {
			targetUserChat = $(this);
			usuarioChatTitulo = $(targetUserChat).find("span").html();
			$(dialog).dialog("option", "title", usuarioChatTitulo);
			$(dialog).dialog("option", "position", {
				my : "right-130",
				of : targetUserChat
			});
			if ($(dialog).dialog("isOpen") == false) {
				openChatMensajePanel();
			}
		});
	}
	
	function processMessage(message) {
		console.log("message");
		console.log(message);
		if (message.messageInfo) {
//			showConversation(message.messageInfo.from);
//			addMessage(message.messageInfo.from, message.messageInfo.message, cleanWhitespaces(message.messageInfo.from) + 'conversation');
		} else if (message.statusInfo) {
			if (message.statusInfo.status == 'CONNECTED') {
				addOnlineUsuario(message.statusInfo.user);
			} else if (message.statusInfo.status == 'DISCONNECTED') {
				removeOnlineUsuario(message.statusInfo.user);
			}
		} else if (message.connectionInfo) {
			var activeUsers = message.connectionInfo.activeUsers;			
			for ( var i = 0; i < activeUsers.length; i++) {
				addOnlineUsuario(activeUsers[i]);
			}
		}
	}
	
	
});
