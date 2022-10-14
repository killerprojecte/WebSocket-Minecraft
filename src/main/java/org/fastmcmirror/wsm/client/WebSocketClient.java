package org.fastmcmirror.wsm.client;

import com.google.gson.JsonParser;
import org.fastmcmirror.wsm.client.data.InfomationParser;
import org.fastmcmirror.wsm.client.data.WebSocketInfomation;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient {
    public WebSocketClient(URI serverUri) {
        super(serverUri);
        InfomationParser.register("websocket", WebSocketInfomation.class);
    }

    public WebSocketClient(String url) throws URISyntaxException {
        this(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("[WS-Minecraft-Client][INFO] Connected WebSocket Server");
    }

    @Override
    public void onMessage(String message) {
        InfomationParser.parse(new JsonParser().parse(message).getAsJsonObject());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("[WS-Minecraft-Client][INFO] Connection closed, code: " + code + ", reason: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("[WS-Minecraft-Client][Error] Connection has a exception: " + ex.getMessage());
    }
}
