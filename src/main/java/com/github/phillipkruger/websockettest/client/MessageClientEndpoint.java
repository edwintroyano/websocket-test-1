package com.github.phillipkruger.websockettest.client;

import javax.enterprise.context.Dependent;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import lombok.extern.java.Log;

/**
 * The endpoint that receive messages
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Dependent
@ClientEndpoint
@Log
public class MessageClientEndpoint {

    @OnMessage
    public void onMessage(String message) {
        log.severe(">>> Websocket client received message " + message);
    }

    
    
}