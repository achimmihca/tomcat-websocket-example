<%--
  Created by IntelliJ IDEA.
  User: stan01
  Date: 30.07.2021
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>WebSocket Example</title>
  </head>
  <body>
    <script>
        const socket = new WebSocket("ws:/localhost:8080/websocketexample/mywebsocket")
        socket.onopen = (e) => console.log('opened WebSocket connection')
        socket.onclose = (e) => console.log('closed WebSocket connection')
        socket.onmessage = (e) => console.log('received from server: ' + e.data)
    </script>
    <p>
        Check the developer tools and execute `socket.send("Hello world!")` to test the WebSocket.
    </p>
  </body>
</html>
