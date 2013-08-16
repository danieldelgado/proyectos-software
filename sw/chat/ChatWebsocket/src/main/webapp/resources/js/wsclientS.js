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
			console.log("onopen");
		};
		ws.onmessage = function(event) {
			console.log("onmessage");	
			console.log(event);			
		};

		ws.onclose = function() {
			console.log("onclose");				
		};
	}
	
	function disconnect() {
		console.log(" disconnect ");
		if (ws != null) {
			ws.close();
			ws = null;
		}
	}
	// metodos publicos
	return {
		connect : connect,
		disconnect : disconnect
	};
})();