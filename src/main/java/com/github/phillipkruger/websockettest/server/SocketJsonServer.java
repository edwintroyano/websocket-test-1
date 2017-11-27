package com.github.phillipkruger.websockettest.server;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.logging.Level;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.extern.java.Log;

@Log
@ServerEndpoint(value = "/test/json",encoders = {JsonEncoder.class})
public class SocketJsonServer {
    
    @OnOpen
    public void onOpen(Session session){
        try {
            session.getBasicRemote().sendObject(toJSON("Hello world"));
        } catch (IOException | EncodeException ex) {
            log.log(Level.SEVERE, null, ex);
        }
    }

    private JsonObject toJSON(String message){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("message",message);
        job.add("uuid", UUID.randomUUID().toString());
        return job.build();
    }
    
}