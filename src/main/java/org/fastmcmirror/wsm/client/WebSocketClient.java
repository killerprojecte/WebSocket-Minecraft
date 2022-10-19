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
        InformationParser.register("websocket", WebSocketInformation.class);
        InformationParser.register("offlinePlayerData", OfflinePlayerInformation.class);
        InformationParser.register("playerData", PlayerInformation.class);
        InformationParser.register("offlinePlayersData", OfflinePlayersInformation.class);
        InformationParser.register("onlinePlayersData", PlayersInformation.class);
        InformationParser.register("playerPointsData", IntInformation.class);
        InformationParser.register("changedPlayerPointsData", PlayerPointsChangeInformation.class);
        InformationParser.register("economyData", DoubleInformation.class);
        InformationParser.register("changedEconomyData", EconomyChangeInformation.class);
        InformationParser.register("hasPermissionData", BooleanInformation.class);
        InformationParser.register("placeholder", StringInformation.class);
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
        InformationParser.parse(new JsonParser().parse(message).getAsJsonObject());
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
