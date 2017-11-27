# websocket-test
Testing some of the Websocket features

## To start in Open Liberty

`mvn clean install -Dliberty`

## To start in Wildfly

`mvn clean install -Dwildfly`

Both will start the server in the foreground (as part of the maven build)

### To test

**To test "sendText" :**

`wget localhost:8080/websocket-test/api/text`

This creates a Websocket client that connect to the server, on connection, the server reply with a Text message that print to the log:

`>>> Websocket client received message Hello world`

**To test "sendObject (POJO)" :**

`wget localhost:8080/websocket-test/api/object`

This creates a Websocket client that connect to the server, on connection, the server reply with a POJO (Message.java) that print to the log:

`>>> Websocket client received message Message [Hello world]`

**To test "sendObject (JSonObject)" :**

`wget localhost:8080/websocket-test/api/json`

This creates a Websocket client that connect to the server, on connection, the server reply with a JSonObject message that print to the log:

`>>> Websocket client received message {"message":"Hello world","uuid":"0fe850b8-6a0e-4f2c-9136-c5ccf36595ac"}`