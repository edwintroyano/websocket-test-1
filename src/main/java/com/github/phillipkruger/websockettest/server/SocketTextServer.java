package com.github.phillipkruger.websockettest.server;

import java.io.IOException;
import java.util.logging.Level;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.extern.java.Log;

@Log
@ServerEndpoint(value = "/test/text")
public class SocketTextServer {
    
    @OnOpen
    public void onOpen(Session session){
        try {
            session.getBasicRemote().sendText("Hello world");
        } catch (IOException ex) {
            log.log(Level.SEVERE, null, ex);
        }
    }
    
}