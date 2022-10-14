package org.fastmcmirror.wsm.server.hook;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class VaultHook {
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;

    private static boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private static boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private static boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static void setup() {
        if (setupEconomy()) {
            Bukkit.getLogger().info("[Vault-Hook] Loaded Vault-Economy Module");
        }
        if (setupChat()) {
            Bukkit.getLogger().info("[Vault-Hook] Loaded Vault-Chat Module");
        }
        if (setupPermissions()) {
            Bukkit.getLogger().info("[Vault-Hook] Loaded Vault-Permissions Module");
        }
    }
}
