var servidorConexion = (function() {
	var ws = null;
	var wsURI = 'ws://' + location.host + '/tutorial/chat';
	    
	    
	return {
		connect : connect,
		disconnect : disconnect
	};  
});