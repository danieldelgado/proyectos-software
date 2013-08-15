var wsclient = (function() {

	var ws = null;
	var wsURI = 'ws://' + location.host + '/ChatWebsocket/chat';
	var usuariosLista = {};
	
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
			setConnected(false);
			document.getElementById('userName').value = '';
			closeAllConversations();
		};

		function processMessage(message) {
			if (message.messageInfo) {
				showConversation(message.messageInfo.from.userName);
				addMessage(message.messageInfo.from.userName, message.messageInfo.message, cleanWhitespaces(message.messageInfo.from.userName) + 'conversation');
			} else if (message.statusInfo) {
				if (message.statusInfo.status == 'CONNECTED') {	
					console.log("message.statusInfo.status");
					console.log(message);
					if(usuarioEstaEnlista(message.statusInfo.user.userName)){
						var li = obtenerLIUsuario(message.statusInfo.user.userName);						
						var span = $(li).find("span");
						$(span).attr({'class' : 'connected'});
					}else{
						addOnlineUser(message.statusInfo.user.userName);
						usuariosLista[message.statusInfo.user.userName] = message.statusInfo.user;
					}
				} else if (message.statusInfo.status == 'DISCONNECTED') {
					var li = obtenerLIUsuario(message.statusInfo.user.userName);
					var span = $(li).find("span");
					$(span).attr({'class' : 'disconnected'});
				}				
			} else if (message.connectionInfo) {
				console.log("message.connectionInfo");
				console.log(message);
				var activeUsers = message.connectionInfo.activeUsers;				
				for ( var i = 0; i < activeUsers.length; i++) {
					usuariosLista[activeUsers[i].userName] = activeUsers[i];
					addOnlineUser(activeUsers[i].userName);
				}
				var activeUsersdesc = message.connectionInfo.activeUsersDesconectados;			
				for ( var i = 0; i < activeUsersdesc.length; i++) {
					usuariosLista[activeUsersdesc[i].userName] = activeUsersdesc[i];
					addlineUser(activeUsersdesc[i].userName);
				}
			}
		}

	}

	function usuarioEstaEnlista(userName){
		var usuario = usuariosLista[userName];
		if(usuario!=null || usuario != undefined){
			console.log("true");
			return true;
		}
		console.log("false");
		return false;
	}
	
	function obtenerUsuarioLista(userName){
		var usuario = usuariosLista[userName];
		if(usuario!=null || usuario != undefined){
			return usuario;
		}
		return null;
	}
	
	function obtenerLIUsuario(userName){
		var li = $("#" +(userName + 'onlineuser'));
		return li;
	}
	
	function disconnect() {
		if (ws != null) {
			ws.close();
			ws = null;
		}
		setConnected(false);
	}

	function setConnected(connected) {
		 $('#connect').attr("disabled",connected);
		 $('#disconnect').attr("disabled",!connected);
		cleanConnectedUsers();
		if (connected) {
			updateUserConnected();
		} else {
			updateUserDisconnected();
		}
	}

	function updateUserConnected() {
		var inputUsername = $('#userName');
		var onLineUserName = $('.onLineUserName');
		onLineUserName.html(inputUsername.val());
		inputUsername.css({
			display : 'none'
		});
		onLineUserName.css({
			visibility : 'visible'
		});
		$('#status').html('Conectado');
		$('#status').attr({
			'class' : 'connected'
		});
		$('#onLineUsersPanel').css({
			visibility : 'visible'
		});
	}

	function updateUserDisconnected() {
		$('.onLineUserName').css({
			visibility : 'hidden'
		});
		$('#userName').css({
			display : ''
		});
		$('#status').html('Desconectado');
		$('#status').attr({
			'class' : 'disconnected'
		});
		$('#onLineUsersPanel').css({
			visibility : 'hidden'
		});
	}

	function cleanConnectedUsers() {
		$('#onlineUsers').html('');
	}

	function removeTab(conversationId) {
		$('#conversations').tabs('remove', conversationId);
	}

	function cleanWhitespaces(text) {
		return text.replace(/\s/g, "_");
	}

	function showConversation(from) {
		var conversations = $('#conversations');
		conversations.css({
			visibility : 'visible'
		});
		var conversationId = cleanWhitespaces(from) + 'conversation';
		if (document.getElementById(conversationId) == null) {
			createConversationPanel(from);
			conversations.tabs('add', '#' + conversationId, from);
		}
		conversations.tabs('select', '#' + conversationId);
		$('#' + conversationId + 'message').focus();
	}

	function createConversationPanel(name) {
		var conversationId = cleanWhitespaces(name) + 'conversation';
		var conversationPanel = $(document.createElement('div'));
		conversationPanel.attr({
			id : conversationId,
			'class' : 'conversation'
		});
		$('<p class="messages"></p>').appendTo(conversationPanel);
		var textAreaMensaje = createtextarea(name, conversationId);
		textAreaMensaje.appendTo(conversationPanel);
		var sendButton = createSendButton(name);
		sendButton.appendTo(conversationPanel);
		var closeButton = createCloseButton(cleanWhitespaces(name));
		closeButton.appendTo(conversationPanel);
		conversationPanel.appendTo($('#conversations'));
	}

	function createtextarea(name, conversationId) {
		var textarea = $(document.createElement('textarea'));
		textarea.attr('id', conversationId + 'message');
		textarea.keypress(function(e) {
			if (e.keyCode == '13') {
				enviarMsj(name, conversationId);
				return false;
			}
		});
		return textarea;
	}

	function enviarMsj(name, conversationId) {
		var from = $('#userName').val();		
		var message = $('#'+conversationId+ 'message').val();//document.getElementById(conversationId + 'message').value
		toChat(from, name, message);
		addMessage(from, message, conversationId);
		document.getElementById(conversationId + 'message').value = '';
	}

	function createSendButton(name) {
		var conversationId = cleanWhitespaces(name) + 'conversation';
		var button = $(document.createElement('button'));
		button.html('Enviar');
		button.click(function() {
			enviarMsj(name, conversationId);
		});
		return button;
	}

	function closeAllConversations() {
		for ( var i = $('#conversations').tabs('length'); i >= 0; i--) {
			$('#conversations').tabs('remove', i - 1);
		}
		$('#conversations').css({
			visibility : 'hidden'
		});
	}

	function createCloseButton(conversationId) {
		var button = $(document.createElement('button'));
		button.html('Cerrar');
		button.click(function() {
			removeTab(conversationId);
		});
		return button;
	}

	function addMessage(from, message, conversationPanelId) {
		var messages = $('#' + conversationPanelId + ' .messages');
		$('<div class="message"><span><b>' + from + '</b> dice:</span><p>' + $('<p/>').text(message).html() + '</p></div>').appendTo(messages);
		messages.scrollTop(messages[0].scrollHeight);
		$('#' + conversationPanelId + ' textarea').focus();
	}

	function toChat(sender, receiver, message) {
		ws.send(JSON.stringify({
			messageInfo : {
				'fromuserName' : sender,
				'touserName' : receiver,
				'message' : message
			}
		}));
	}

	/** ******* usuarios conectados ****** */
	function addOnlineUser(userName) {
		var newOnlineUser = createOnlineUser(userName);
		newOnlineUser.appendTo($('#onlineUsers'));
	}

	function addlineUser(userName) {
		var newOnlineUser = createlineUser(userName);
		newOnlineUser.appendTo($('#onlineUsers'));
	}
	
	function removeOnlineUser(userName) {
		$('#onlineUsers > li').each(function(index, elem) {
			if (elem.id == userName + 'onlineuser') {
				$(elem).remove();
			}
		});
	}

	function createOnlineUser(userName) {
		var link = $(document.createElement('a'));		
		var spanStatus = $(document.createElement('span')).attr({'class' : 'connected','style':' padding: 0 0 0 20px; display: block; '});
		spanStatus.html(userName);
		link.html(spanStatus);		
		link.click(function() {
			showConversation(userName);
		});
		var li = $(document.createElement('li'));
		li.attr({
			id : (userName + 'onlineuser')
		});
		link.appendTo(li);
		return li;
	}
	
	function createlineUser(userName) {
		var link = $(document.createElement('a'));		
		var spanStatus = $(document.createElement('span')).attr({'class' : 'disconnected','style':' padding: 0 0 0 20px; display: block; '});
		spanStatus.html(userName);
		link.html(spanStatus);
		link.click(function() {
			showConversation(userName);
		});
		var li = $(document.createElement('li'));
		li.attr({
			id : (userName + 'onlineuser')
		});
		link.appendTo(li);
		return li;
	}
	// metodos publicos
	return {
		connect : connect,
		disconnect : disconnect
	};
})();