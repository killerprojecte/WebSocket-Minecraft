package org.fastmcmirror.wsm.server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.fastmcmirror.wsm.server.data.CommandParser;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;

public class WebSocketServer extends org.java_websocket.server.WebSocketServer {

    public static long starttime;
    private String token;

    public WebSocketServer(InetSocketAddress inetSocketAddress, String token) {
        super(inetSocketAddress);
        this.token = token;
        starttime = System.currentTimeMillis();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        if (!conn.getResourceDescriptor().substring(1).equals(token)) {
            conn.close(1003, "Forbidden Access");
        }
        System.out.println("[WS-Minecraft][INFO] new connection: " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        if (code == 1000) return;
        System.out.println("[WS-Minecraft][INFO] Connection closed: " + conn.getRemoteSocketAddress().getAddress().getHostAddress() + ", code: " + code + ", reason: " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        JsonObject object = new JsonParser().parse(message).getAsJsonObject();
        CommandParser.parseCommand(conn, object);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("[WS-Minecraft][Error] has a exception in connection " + conn.getRemoteSocketAddress().getAddress().getHostAddress() + ": " + ex.getMessage());
    }

    @Override
    public void onStart() {

    }
}
