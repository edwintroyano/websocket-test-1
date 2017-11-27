package com.github.phillipkruger.websockettest.client;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import lombok.extern.java.Log;

@Path("")
@Log
public class MessageClientListener {
    
    @GET
    @Path("{type}")
    public Response connect(@PathParam("type") String type) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(MessageClientEndpoint.class, URI.create("ws://localhost:8080/websocket-test/test/" + type));
        } catch (DeploymentException | IOException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return Response.accepted().build();
    }

}