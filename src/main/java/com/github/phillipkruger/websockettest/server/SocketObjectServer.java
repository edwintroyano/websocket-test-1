package com.github.phillipkruger.websockettest.server;

import java.io.IOException;
import java.util.logging.Level;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.extern.java.Log;

@Log
@ServerEndpoint(value = "/test/object",encoders = {MessageEncoder.class})
public class SocketObjectServer {
    
    @OnOpen
    public void onOpen(Session session){
        try {
            session.getBasicRemote().sendObject(new Message("Hello world"));
        } catch (IOException | EncodeException ex) {
            log.log(Level.SEVERE, null, ex);
        }
    }
    
}