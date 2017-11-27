package com.github.phillipkruger.websockettest.server;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public String encode(Message message) throws EncodeException {
        return "Message [" + message.getMessage() + "]";
    }

    @Override
    public void destroy() {}

}