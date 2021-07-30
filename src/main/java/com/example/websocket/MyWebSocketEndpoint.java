package com.example.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Tomcat will scan for classes with the ServerEndpoint-annotation
 * and register the endpoint automatically on deploy of the web-app.
 * Thus, no configuration in web.xml or similar is required.
 */
@ServerEndpoint("/mywebsocket")
public class MyWebSocketEndpoint
{
    private Session session;

    @OnOpen
    public void onOpen(Session session)
    {
        this.session = session;
        System.out.println("Opened WebSocket connection");
    }

    @OnMessage
    public void onMessage(String message)
    {
        try
        {
            if (this.session != null && this.session.isOpen())
            {
                System.out.println("Received from client: " + message);
                this.session.getBasicRemote().sendText("Sent from server: " + message);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose()
    {
        System.out.println("Closed WebSocket connection");
    }

    @OnError
    public void onError(Throwable e)
    {
        System.out.println("WebSocket error");
        e.printStackTrace();
    }
}
