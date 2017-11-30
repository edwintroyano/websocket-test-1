package com.github.phillipkruger.websockettest.server;

import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class AnotherJsonEncoder implements Encoder.Text<JsonObject> {

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public String encode(JsonObject payload) throws EncodeException {
        return "This silly encode just overides your payload";
    }

    @Override
    public void destroy() {}

}