<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xml:lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Autentia - Ejemplo simple con Websockets y Tomcat 7</title>
</head>
<body>

<a href="http://www.autentia.com" target="_blank"><img src="<c:url value="/resources/img/autentia.png" ></c:url>" alt="Autentia"/></a>
<h1>EJEMPLO SIMPLE DE WEBSOCKETS CON TOMCAT 7</h1>
<script type="text/javascript">

    var ws = null;

    function connect() {
        var URL = 'ws://' + location.host  + '/tutorial/simple';
        console.log("URL:"+URL);
        if ('WebSocket' in window) {
            ws = new WebSocket(URL);
            console.log("ws WebSocket :");
            console.log(ws);
        } else if ('MozWebSocket' in window) {
            ws = new MozWebSocket(URL);
            console.log(ws);
        } else {
            alert('Tu navegador no soporta WebSockets');
            return;
        }
        ws.onopen = function () {
            addMessage('server Concectado!');
            console.log(" conexion habierta :");
        };
        ws.onmessage = function (event) {
            var message = event.data;
            console.log(" message : " +message);
            addMessage(message);
        };

        ws.onclose = function () {
            addMessage('Desconectado!');
            console.log(" conexion cerrada :");
        };

        ws.onerror = function (event) {
            addMessage('Se produjo un error!');
            console.log(" error : " +event);
        };
    }

    function disconnect() {
        if (ws != null) {
        	console.log("disconnect");
            ws.close();
            ws = null;
        }
    }

    function sendMessage(message) {
        if (ws != null) {
        	console.log("sendMessage message:"+message);
            ws.send(message);
        }
    }

    function addMessage(message) {
    	console.log("addMessage message:"+message);
        var messages = document.getElementById('messages').value;
        messages += (message + '\n');
        document.getElementById('messages').value = messages;
    }

</script>

<label for="name">Nombre:</label> <input type="text" id="name"/>
<br/><br/>
<button onclick="connect()">Conectar</button>
<button onclick="disconnect()">Desconectar</button>
<button onclick="sendMessage(document.getElementById('name').value)">Enviar mensaje</button>
<br/><br/>
<textarea rows="5" cols="50" id="messages"></textarea>

</body>
</html>