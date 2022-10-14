package org.fastmcmirror.wsm;

import org.bukkit.plugin.java.JavaPlugin;
import org.fastmcmirror.wsm.server.WebSocketServer;

import java.net.InetSocketAddress;

public final class WSMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[WS-Minecraft] Starting WebSocket-Server...");
        Thread thread = new Thread(new WebSocketServer(new InetSocketAddress(getConfig().getInt("port")),getConfig().getString("token")));
        thread.start();
        getLogger().info("[WS-Minecraft] WebSocket-Server Started!");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
