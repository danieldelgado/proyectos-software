<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        
    <link type="text/css" href="<c:url value="resources/css/default.css?123" ></c:url>" rel="stylesheet" />
    <link type="text/css" href="<c:url value="resources/css/smoothness/jquery-ui-1.8.22.custom.css" ></c:url>" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="resources/js/jquery-1.7.2.min.js" ></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/jquery-ui-1.8.22.custom.min.js"></c:url>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/wsclientOriginal.js"></c:url>"></script>
    <title>Autentia - Chat con Websockets y Tomcat 7</title>
    <script type="text/javascript">
        $(function(){
            $('#conversations').tabs();
        });
    </script>
</head>
<body>
<a href="http://www.autentia.com" target="_blank"><img src="resources/img/autentia.png" alt="Autentia"/></a>
<h1>EJEMPLO DE WEBSOCKETS CON TOMCAT 7</h1>
<div id="container">
    <div class="leftPanel">
        <div class="userInfo">
            <span class="disconnected" id="status">Desconectado</span>
            Nombre: <input type="text" id="userName"/><span class="onLineUserName"></span>
        </div>
        <div>
            <button id="connect" onclick="wsclient.connect(document.getElementById('userName').value);">Conectar</button>
            <button id="disconnect" disabled="disabled" onclick="wsclient.disconnect();">Desconexión</button>
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