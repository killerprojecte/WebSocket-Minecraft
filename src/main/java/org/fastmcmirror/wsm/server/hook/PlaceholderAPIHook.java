package org.fastmcmirror.wsm.server.hook;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class PlaceholderAPIHook {
    public static String parse(String placeholder, OfflinePlayer player) {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) return placeholder;
        return PlaceholderAPI.setPlaceholders(player, placeholder);
    }
}
