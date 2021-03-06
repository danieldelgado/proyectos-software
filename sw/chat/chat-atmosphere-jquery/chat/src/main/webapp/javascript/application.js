$(function () {
//    "use strict";

    var header = $('#header');
    var content = $('#content');
    var input = $('#input');
    var status = $('#status');
    var myName = false;
    var author = null;
    var logged = false;
    var socket = atmosphere;
    var subSocket;
    var transport = 'websocket';

    // We are now ready to cut the request
    var request = { 
    	url: document.location.toString() + 'chat',
        contentType : "application/json",
        logLevel : 'debug',
        transport : transport ,
        trackMessageLength : true,
        reconnectInterval : 5000,
        fallbackTransport: 'long-polling'
        	};

    console.log("request");
    console.log(request);

    request.onOpen = function(response) {
    	 console.log("onOpen");
    	    console.log(response);
        content.html($('<p>', { text: 'Atmosphere connected using ' + response.transport }));
        input.removeAttr('disabled').focus();
        status.text('Choose name:');
        transport = response.transport;
    };

    request.onReopen = function(response) {
   	 console.log("onReopen");
	    console.log(response);
        input.removeAttr('disabled').focus();
        content.html($('<p>', { text: 'Atmosphere re-connected using ' + response.transport }));
    };

//    <!-- For demonstration of how you can customize the fallbackTransport using the onTransportFailure function -->
    request.onTransportFailure = function(errorMsg, request) {
      	 console.log("onTransportFailure");
  	    console.log(errorMsg);
 	    console.log(request);
        atmosphere.util.info(errorMsg);
        if (window.EventSource) {
            request.fallbackTransport = "sse";
        }
        header.html($('<h3>', { text: 'Atmosphere Chat. Default transport is WebSocket, fallback is ' + request.fallbackTransport }));
    };

    request.onMessage = function (response) {
     	 console.log("onMessage");
   	    console.log(response);

        var message = response.responseBody;
        try {
            var json = atmosphere.util.parseJSON(message);
        } catch (e) {
            console.log('This doesn\'t look like a valid JSON: ', message);
            return;
        }

        input.removeAttr('disabled').focus();
        if (!logged && myName) {
            logged = true;
            status.text(myName + ': ').css('color', 'blue');
        } else {
            var me = json.author == author;
            var date = typeof(json.time) == 'string' ? parseInt(json.time) : json.time;
            addMessage(json.author, json.message, me ? 'blue' : 'black', new Date(date));
        }
    };

    request.onClose = function(response) {
    	 console.log("onClose");
 	    console.log(response);
	    console.log(subSocket);
        content.html($('<p>', { text: 'Client closed the connection after a timeout' }));
        subSocket.push(atmosphere.util.stringifyJSON({ author: author, message: 'disconnecting' }));
        input.attr('disabled', 'disabled');
    };

    request.onError = function(response) {
   	 console.log("onError");
 	    console.log(response);
        content.html($('<p>', { text: 'Sorry, but there\'s some problem with your '
            + 'socket or the server is down' }));
        logged = false;
    };

    request.onReconnect = function(request, response) {
      	 console.log("onReconnect");
   	    console.log(request);
  	    console.log(response);
        content.html($('<p>', { text: 'Connection lost, trying to reconnect. Trying to reconnect ' + request.reconnectInterval}));
        input.attr('disabled', 'disabled');
    };

    subSocket = socket.subscribe(request);

    input.keydown(function(e) {
        if (e.keyCode === 13) {
            var msg = $(this).val();

            // First message is always the author's name
            if (author == null) {
                author = msg;
            }

            subSocket.push(atmosphere.util.stringifyJSON({ author: author, message: msg }));
            $(this).val('');

            input.attr('disabled', 'disabled');
            if (myName === false) {
                myName = msg;
            }
        }
    });

    function addMessage(author, message, color, datetime) {
     	 console.log("addMessage");
 	    console.log(author);
	    console.log(message);
	    console.log(color);
	    console.log(datetime);
        content.append('<p><span style="color:' + color + '">' + author + '</span> @ ' +
            + (datetime.getHours() < 10 ? '0' + datetime.getHours() : datetime.getHours()) + ':'
            + (datetime.getMinutes() < 10 ? '0' + datetime.getMinutes() : datetime.getMinutes())
            + ': ' + message + '</p>');
    }
});
