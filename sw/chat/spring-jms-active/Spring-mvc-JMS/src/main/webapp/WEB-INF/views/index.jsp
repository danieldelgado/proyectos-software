<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        
    <link type="text/css" href="<c:url value="resources/css/default.css?123" ></c:url>" rel="stylesheet" />
    <link type="text/css" href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/stomp.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/activeMQClient.js"></c:url>"></script>
    <title>Autentia - Chat con Websockets y Tomcat 7</title>
    <script type="text/javascript">
        $(function(){
            $('#conversations').tabs();
//             console.log("conversations");
        });
//         console.log("wsclient");
//         console.log(wsclient);
    </script>
</head>
<body>



<h1>WEBSOCKETS STOMP Y ACTIVEMQ</h1>

<div id="container">
    <div class="leftPanel">
        <div class="userInfo">
            <span class="disconnected" id="status">Desconectado</span>
            Nombre: <input type="text" id="userName"/><span class="onLineUserName"></span>
        </div>
        <div>
            <button id="connect" onclick="ActiveMQClient.connect($('#userName').val());">Conectar</button>
            <button id="disconnect" disabled="disabled" onclick="ActiveMQClient.disconnect()">Desconexi&oacute;n</button>
        </div>
        <div id="onLineUsersPanel">
            <h3>Usuarios conectados:</h3>
            <ul id="onlineUsers">

            </ul>
        </div>

    </div>

    <div id="conversations">
        <ul>
        </ul>
    </div>
</div>





</body>
</html>