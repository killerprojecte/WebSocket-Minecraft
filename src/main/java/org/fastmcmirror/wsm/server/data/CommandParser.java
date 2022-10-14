package org.fastmcmirror.wsm.server.data;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.fastmcmirror.wsm.WSMinecraft;
import org.fastmcmirror.wsm.server.WebSocketServer;
import org.fastmcmirror.wsm.server.hook.PlaceholderAPIHook;
import org.fastmcmirror.wsm.server.hook.PlayerPointsHook;
import org.fastmcmirror.wsm.server.hook.VaultHook;
import org.fastmcmirror.wsm.server.serialization.*;
import org.java_websocket.WebSocket;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    public static void parseCommand(WebSocket webSocket, JsonObject jsonObject) {
        CommandParserData data = new Gson().fromJson(jsonObject, CommandParserData.class);
        Bukkit.getScheduler().runTask(WSMinecraft.instance, () -> {
            switch (data.commandId) {
                case "test": {
                    System.out.println("test!");
                    break;
                }
                case "serverInfo": {
                    JsonObject js = new JsonObject();
                    js.addProperty("type", "websocket");
                    JsonObject jsdata = new JsonObject();
                    jsdata.addProperty("worktime", (System.currentTimeMillis() - WebSocketServer.starttime));
                    js.add("data", jsdata);
                    webSocket.send(new Gson().toJson(js));
                    break;
                }
                case "commandExcute": {
                    CommandExcuteData subData = new Gson().fromJson(data.data, CommandExcuteData.class);
                    for (String c : subData.commands) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), c);
                    }
                    break;
                }
                case "getOfflinePlayer": {
                    GetOfflinePlayerData subData = new Gson().fromJson(data.data, GetOfflinePlayerData.class);
                    webSocket.send(new TypeData("offlinePlayerData", new Gson().toJsonTree(new OfflinePlayerData(Bukkit.getOfflinePlayer(subData.name))).getAsJsonObject()).getJson());
                    break;
                }
                case "getPlayer": {
                    GetOfflinePlayerData subData = new Gson().fromJson(data.data, GetOfflinePlayerData.class);
                    webSocket.send(new TypeData("playerData", new Gson().toJsonTree(new PlayerData(Bukkit.getPlayer(subData.name))).getAsJsonObject()).getJson());
                    break;
                }
                case "getOfflinePlayers": {
                    webSocket.send(new TypeData("offlinePlayersData",
                            new Gson().toJsonTree(
                                    new ArrayData(getOfflinePlayers())
                            )
                    ).getJson());
                    break;
                }
                case "getOnlinePlayers": {
                    webSocket.send(new TypeData("onlinePlayersData",
                            new Gson().toJsonTree(
                                    new ArrayData(getPlayers())
                            )
                    ).getJson());
                    break;
                }
                case "getPlayerPoints": {
                    GetOfflinePlayerData subData = new Gson().fromJson(data.data, GetOfflinePlayerData.class);
                    if (PlayerPointsHook.api == null) {
                        webSocket.send(new TypeData("playerPointsData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    webSocket.send(new TypeData("playerPointsData", new Gson().toJsonTree(new IntData(
                            PlayerPointsHook.api.look(Bukkit.getOfflinePlayer(subData.name).getUniqueId())
                    ))).getJson());
                    break;
                }
                case "takePlayerPoints": {
                    PlayerPointsModifyData subData = new Gson().fromJson(data.data, PlayerPointsModifyData.class);
                    if (PlayerPointsHook.api == null) {
                        webSocket.send(new TypeData("changedPlayerPointsData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    int has = PlayerPointsHook.api.look(Bukkit.getOfflinePlayer(subData.name).getUniqueId());
                    int count = subData.count;
                    if (count > has) {
                        webSocket.send(new TypeData("changedPlayerPointsData", new Gson().toJsonTree(new PlayerPointsChangedData(false, has, count - has))).getJson());
                    } else {
                        PlayerPointsHook.api.take(Bukkit.getOfflinePlayer(subData.name).getUniqueId(), count);
                        webSocket.send(new TypeData("changedPlayerPointsData", new Gson().toJsonTree(new PlayerPointsChangedData(true, PlayerPointsHook.api.look(Bukkit.getOfflinePlayer(subData.name).getUniqueId()), 0))).getJson());
                    }
                    break;
                }
                case "givePlayerPoints": {
                    PlayerPointsModifyData subData = new Gson().fromJson(data.data, PlayerPointsModifyData.class);
                    if (PlayerPointsHook.api == null) {
                        webSocket.send(new TypeData("changedPlayerPointsData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    int count = subData.count;
                    PlayerPointsHook.api.give(Bukkit.getOfflinePlayer(subData.name).getUniqueId(), count);
                    webSocket.send(new TypeData("changedPlayerPointsData", new Gson().toJsonTree(new PlayerPointsChangedData(true, PlayerPointsHook.api.look(Bukkit.getOfflinePlayer(subData.name).getUniqueId()), 0))).getJson());
                    break;
                }
                case "setPlayerPoints": {
                    PlayerPointsModifyData subData = new Gson().fromJson(data.data, PlayerPointsModifyData.class);
                    if (PlayerPointsHook.api == null) {
                        webSocket.send(new TypeData("changedPlayerPointsData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    int count = subData.count;
                    PlayerPointsHook.api.set(Bukkit.getOfflinePlayer(subData.name).getUniqueId(), count);
                    webSocket.send(new TypeData("changedPlayerPointsData", new Gson().toJsonTree(new PlayerPointsChangedData(true, PlayerPointsHook.api.look(Bukkit.getOfflinePlayer(subData.name).getUniqueId()), 0))).getJson());
                    break;
                }
                case "getEconomy": {
                    GetOfflinePlayerData subData = new Gson().fromJson(data.data, GetOfflinePlayerData.class);
                    if (VaultHook.econ == null) {
                        webSocket.send(new TypeData("economyData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    webSocket.send(new TypeData("economyData", new Gson().toJsonTree(new DoubleData(
                            VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name))
                    ))).getJson());
                }
                case "takeEconomy": {
                    EconomyModifyData subData = new Gson().fromJson(data.data, EconomyModifyData.class);
                    if (VaultHook.econ == null) {
                        webSocket.send(new TypeData("changedEconomyData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    double has = VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name));
                    double count = subData.count;
                    if (count > has) {
                        webSocket.send(new TypeData("changedEconomyData", new Gson().toJsonTree(new EconomyChangedData(false, has, count - has))).getJson());
                    } else {
                        VaultHook.econ.withdrawPlayer(Bukkit.getOfflinePlayer(subData.name), count);
                        webSocket.send(new TypeData("changedEconomyData", new Gson().toJsonTree(new EconomyChangedData(true, VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name)), 0))).getJson());
                    }
                    break;
                }
                case "giveEconomy": {
                    EconomyModifyData subData = new Gson().fromJson(data.data, EconomyModifyData.class);
                    if (VaultHook.econ == null) {
                        webSocket.send(new TypeData("changedEconomyData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    double count = subData.count;
                    VaultHook.econ.depositPlayer(Bukkit.getOfflinePlayer(subData.name), count);
                    webSocket.send(new TypeData("changedEconomyData", new Gson().toJsonTree(new EconomyChangedData(true, VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name)), 0))).getJson());
                    break;
                }
                case "setEconomy": {
                    EconomyModifyData subData = new Gson().fromJson(data.data, EconomyModifyData.class);
                    if (VaultHook.econ == null) {
                        webSocket.send(new TypeData("changedEconomyData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    double count = subData.count;
                    VaultHook.econ.withdrawPlayer(Bukkit.getOfflinePlayer(subData.name), VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name)));
                    VaultHook.econ.depositPlayer(Bukkit.getOfflinePlayer(subData.name), count);
                    webSocket.send(new TypeData("changedEconomyData", new Gson().toJsonTree(new EconomyChangedData(true, VaultHook.econ.getBalance(Bukkit.getOfflinePlayer(subData.name)), 0))).getJson());
                    break;
                }
                case "hasPermission": {
                    HasPermissionData subData = new Gson().fromJson(data.data, HasPermissionData.class);
                    if (VaultHook.perms == null) {
                        webSocket.send(new TypeData("hasPermissionData", JsonNull.INSTANCE).getJson());
                        break;
                    }
                    webSocket.send(new TypeData("hasPermissionData", new Gson().toJsonTree(new BooleanData(VaultHook.perms.playerHas(subData.world, Bukkit.getOfflinePlayer(subData.name), subData.permission)))).getJson());
                    break;
                }
                case "parsePlaceholder": {
                    PlaceholderData subData = new Gson().fromJson(data.data, PlaceholderData.class);
                    webSocket.send(new TypeData("placeholder", new Gson().toJsonTree(new StringData(PlaceholderAPIHook.parse(subData.placeholder, Bukkit.getOfflinePlayer(subData.name))))).getJson());
                    break;
                }
            }
        });
    }

    private static List<OfflinePlayerData> getOfflinePlayers() {
        List<OfflinePlayerData> list = new ArrayList<>();
        for (OfflinePlayer ofp : Bukkit.getOfflinePlayers()) {
            list.add(new OfflinePlayerData(ofp));
        }
        return list;
    }

    private static List<PlayerData> getPlayers() {
        List<PlayerData> list = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            list.add(new PlayerData(p));
        }
        return list;
    }
}
