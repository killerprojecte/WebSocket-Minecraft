package org.fastmcmirror.wsm.client;

import com.google.gson.JsonParser;
import org.fastmcmirror.wsm.client.command.CommandSender;
import org.fastmcmirror.wsm.client.data.*;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient {
    public static WebSocketClient webSocket;
    public static Map<Long, CommandSender<?>> tasks = new HashMap<>();

    public WebSocketClient(URI serverUri) {
        super(serverUri);
        InfomationParser.register("websocket", WebSocketInfomation.class);
        InfomationParser.register("offlinePlayerData", OfflinePlayerInfomation.class);
        InfomationParser.register("playerData", PlayerInfomation.class);
        InfomationParser.register("offlinePlayersData", OfflinePlayersInfomation.class);
        InfomationParser.register("onlinePlayersData", PlayersInfomation.class);
        InfomationParser.register("playerPointsData", IntInfomation.class);
        InfomationParser.register("changedPlayerPointsData", PlayerPointsChangeInfomation.class);
        InfomationParser.register("economyData", DoubleInfomation.class);
        InfomationParser.register("changedEconomyData", EconomyChangeInfomation.class);
        InfomationParser.register("hasPermissionData", BooleanInfomation.class);
        InfomationParser.register("placeholder", StringInfomation.class);
        webSocket = this;
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
