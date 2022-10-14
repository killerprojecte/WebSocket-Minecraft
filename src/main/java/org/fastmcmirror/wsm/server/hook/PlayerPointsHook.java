package org.fastmcmirror.wsm.server.hook;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.fastmcmirror.wsm.WSMinecraft;

public class PlayerPointsHook {
    public static PlayerPointsAPI api = null;

    public static void setup() {
        if (Bukkit.getPluginManager().getPlugin("PlayerPoints") != null) {
            api = ((PlayerPoints) Bukkit.getPluginManager().getPlugin("PlayerPoints")).getAPI();
            WSMinecraft.instance.getLogger().info("[PlayerPoints-Hook] Loaded PlayerPoints Moudle");
        }
    }
}
