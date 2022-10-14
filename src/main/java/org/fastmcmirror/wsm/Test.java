package org.fastmcmirror.wsm;

import org.fastmcmirror.wsm.client.WebSocketClient;
import org.fastmcmirror.wsm.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        Thread thread = new Thread(() -> {
            WebSocketServer server = new WebSocketServer(new InetSocketAddress(5000),"1145141919810");
            server.run();
        });
        thread.start();
        WebSocketClient client = new WebSocketClient("ws://127.0.0.1:5000/1145141919810");
        client.connectBlocking();
        client.send("{" +
                "commandId: \"serverInfo\"," +
                "data: {" +
                "test: \"a\"" +
                "}" +
                "}");
    }
}
