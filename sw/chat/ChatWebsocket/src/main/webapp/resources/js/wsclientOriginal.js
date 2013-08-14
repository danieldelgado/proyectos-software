var wsclient = (function() {

	var ws = null;
	var wsURI = 'ws://' + location.host + '/ChatWebsocket/chat';
	console.log("wsURI:" + wsURI);

	function connect(userName) {
		console.log("userName:" + userName);

		if (!userName || userName == '') {
			return;
		}

		if ('WebSocket' in window) {
			ws = new WebSocket(wsURI + '?userName=' + userName);
			console.log(" ws WebSocket:" + wsURI + '?userName=' + userName);
			console.log(ws);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(wsURI + '?userName=' + userName);
			console.log(" ws MozWebSocket:" + wsURI + '?userName=' + userName);
			console.log(ws);
		} else {
			alert('Tu navegador no soporta WebSockets');
			return;
		}
		ws.onopen = function() {
			console.log(" onopen setConnected true");
			setConnected(true);
		};
		ws.onmessage = function(event) {
			var message = JSON.parse(event.data);
			console.log("  onmessage :" );
			console.log( message);
			processMessage(message);
		};

		ws.onclose = function() {
			console.log(" onclose setConnected false closeAllConversations");
			setConnected(false);
			document.getElementById('userName').value = '';
			closeAllConversations();
		};

		function processMessage(message) {
			console.log(" processMessage :" );
			console.log( message);
			if (message.messageInfo) {
				showConversation(message.messageInfo.from);
				addMessage(message.messageInfo.from, message.messageInfo.message, cleanWhitespaces(message.messageInfo.from) + 'conversation');
			} else if (message.statusInfo) {
				if (message.statusInfo.status == 'CONNECTED') {
					addOnlineUser(message.statusInfo.user);
				} else if (message.statusInfo.status == 'DISCONNECTED') {
					removeOnlineUser(message.statusInfo.user);
				}
			} else if (message.connectionInfo) {
				var activeUsers = message.connectionInfo.activeUsers;
				for ( var i = 0; i < activeUsers.length; i++) {
					addOnlineUser(activeUsers[i]);
				}
			}
		}

	}

	function disconnect() {
		console.log(" disconnect ");
		if (ws != null) {
			ws.close();
			ws = null;
		}
		setConnected(false);
	}

	function setConnected(connected) {
		console.log(" setConnected connected:" );
		console.log( connected);
		document.getElementById('connect').disabled = connected;
		document.getElementById('disconnect').disabled = !connected;
		cleanConnectedUsers();
		if (connected) {
			updateUserConnected();
		} else {
			updateUserDisconnected();
		}
	}

	function updateUserConnected() {
		console.log(" updateUserConnected ");
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
			class : 'connected'
		});
		$('#onLineUsersPanel').css({
			visibility : 'visible'
		});
	}

	function updateUserDisconnected() {
		console.log(" updateUserDisconnected ");
		$('.onLineUserName').css({
			visibility : 'hidden'
		});
		$('#userName').css({
			display : ''
		});
		$('#status').html('Desconectado');
		$('#status').attr({
			class : 'disconnected'
		});
		$('#onLineUsersPanel').css({
			visibility : 'hidden'
		});
	}

	function cleanConnectedUsers() {
		console.log(" cleanConnectedUsers ");
		$('#onlineUsers').html('');
	}

	function removeTab(conversationId) {
		console.log(" removeTab ");
		$('#conversations').tabs('remove', conversationId);
	}

	function cleanWhitespaces(text) {
		console.log(" cleanWhitespaces ");
		return text.replace(/\s/g, "_");
	}

	function showConversation(from) {
		console.log(" showConversation ");
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
		console.log(" createConversationPanel ");
		var conversationId = cleanWhitespaces(name) + 'conversation';
		var conversationPanel = $(document.createElement('div'));
		conversationPanel.attr({
			id : conversationId,
			class : 'conversation'
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
		var from = document.getElementById('userName').value;
		var message = document.getElementById(conversationId + 'message').value;
		toChat(from, name, message);
		addMessage(from, message, conversationId);
		document.getElementById(conversationId + 'message').value = '';
	}

	function createSendButton(name) {
		console.log(" createSendButton ");
		var conversationId = cleanWhitespaces(name) + 'conversation';
		var button = $(document.createElement('button'));
		button.html('Enviar');
		button.click(function() {
			enviarMsj(name, conversationId);
		});
		return button;
	}

	function closeAllConversations() {
		console.log(" closeAllConversations ");
		for ( var i = $('#conversations').tabs('length'); i >= 0; i--) {
			$('#conversations').tabs('remove', i - 1);
		}
		$('#conversations').css({
			visibility : 'hidden'
		});
	}

	function createCloseButton(conversationId) {
		console.log(" createCloseButton :" );
		console.log(conversationId);
		var button = $(document.createElement('button'));
		button.html('Cerrar');
		button.click(function() {
			removeTab(conversationId);
		});
		return button;
	}

	function addMessage(from, message, conversationPanelId) {
		console.log(" addMessage :" );
		console.log(addMessage);
		var messages = $('#' + conversationPanelId + ' .messages');
		$('<div class="message"><span><b>' + from + '</b> dice:</span><p>' + $('<p/>').text(message).html() + '</p></div>').appendTo(messages);
		messages.scrollTop(messages[0].scrollHeight);
		$('#' + conversationPanelId + ' textarea').focus();
	}

	function toChat(sender, receiver, message) {
		console.log(" toChat sender:" );
		console.log( sender    );
		console.log(   receiver  );
		console.log(     message);
		ws.send(JSON.stringify({
			messageInfo : {
				from : sender,
				to : receiver,
				message : message
			}
		}));
	}

	/** ******* usuarios conectados ****** */
	function addOnlineUser(userName) {
		console.log(" addOnlineUser :" );
		console.log(userName);
		var newOnlineUser = createOnlineUser(userName);
		newOnlineUser.appendTo($('#onlineUsers'));
	}

	function removeOnlineUser(userName) {
		console.log(" removeOnlineUser :" );
		console.log( userName);
		$('#onlineUsers > li').each(function(index, elem) {
			if (elem.id == userName + 'onlineuser') {
				$(elem).remove();
			}
		});
	}

	function createOnlineUser(userName) {
		console.log(" createOnlineUser :" );
		console.log( userName);
		var link = $(document.createElement('a'));
		link.html(userName);
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