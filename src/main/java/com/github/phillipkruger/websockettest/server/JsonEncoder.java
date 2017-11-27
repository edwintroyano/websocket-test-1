package com.github.phillipkruger.websockettest.server;

import java.io.IOException;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class JsonEncoder implements Encoder.Text<JsonObject> {

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public String encode(JsonObject payload) throws EncodeException {
        
        try (StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(payload);
            return stringWriter.toString();
        } catch (IOException ex) {
            throw new EncodeException(payload,"JsonEncoder could not encode JsonObject",ex);
        }
    }

    @Override
    public void destroy() {}

}