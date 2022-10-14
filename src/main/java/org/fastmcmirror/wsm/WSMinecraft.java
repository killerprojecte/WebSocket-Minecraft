package org.fastmcmirror.wsm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.fastmcmirror.wsm.server.WebSocketServer;
import org.fastmcmirror.wsm.server.hook.PlayerPointsHook;
import org.fastmcmirror.wsm.server.hook.VaultHook;
import org.java_websocket.WebSocket;

import java.net.InetSocketAddress;

public final class WSMinecraft extends JavaPlugin {

    public static WSMinecraft instance;
    public static WebSocketServer wsServer;
    public static Thread thread;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("[WS-Minecraft] Starting WebSocket-Server...");
        thread = new Thread(wsServer = new WebSocketServer(new InetSocketAddress(getConfig().getInt("port")), getConfig().getString("token")));
        thread.start();
        getLogger().info("[WS-Minecraft] WebSocket-Server Started!");
        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            VaultHook.setup();
        }
        if (Bukkit.getPluginManager().getPlugin("PlayerPoints") != null) {
            PlayerPointsHook.setup();
        }
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        try {
            for (WebSocket webSocket : wsServer.getConnections()){
                webSocket.close(1000,"closed");
            }
            wsServer.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.stop();
        // Plugin shutdown logic
    }
}
