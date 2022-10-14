package org.fastmcmirror.wsm.server.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.fastmcmirror.wsm.server.WebSocketServer;
import org.fastmcmirror.wsm.server.serialization.OfflinePlayerData;
import org.fastmcmirror.wsm.server.serialization.PlayerData;
import org.fastmcmirror.wsm.server.serialization.TypeData;
import org.java_websocket.WebSocket;

import java.util.Arrays;
import java.util.Collection;

public class CommandParser {
    public static void parseCommand(WebSocket webSocket, JsonObject jsonObject){
        CommandParserData data = new Gson().fromJson(jsonObject,CommandParserData.class);
        switch (data.commandId){
            case "test":{
                System.out.println("test!");
                break;
            }
            case "serverInfo":{
                JsonObject js = new JsonObject();
                js.addProperty("type","websocket");
                JsonObject jsdata = new JsonObject();
                jsdata.addProperty("worktime",(System.currentTimeMillis() - WebSocketServer.starttime));
                js.add("data",jsdata);
                webSocket.send(new Gson().toJson(js));
            }
            case "commandExcute":{
                CommandExcuteData subData = new Gson().fromJson(data.data,CommandExcuteData.class);
                for (String c : subData.commands){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),c);
                }
                break;
            }
            case "getOfflinePlayer":{
                GetOfflinePlayerData subData = new Gson().fromJson(data.data,GetOfflinePlayerData.class);
                webSocket.send(new TypeData("offlinePlayerData", new Gson().toJsonTree(new OfflinePlayerData(Bukkit.getOfflinePlayer(subData.name))).getAsJsonObject()).getJson());
                break;
            }
            case "getPlayer":{
                GetOfflinePlayerData subData = new Gson().fromJson(data.data,GetOfflinePlayerData.class);
                webSocket.send(new TypeData("playerData", new Gson().toJsonTree(new PlayerData(Bukkit.getPlayer(subData.name))).getAsJsonObject()).getJson());
                break;
            }
            case "getOfflinePlayers":{
                webSocket.send(new TypeData("offlinePlayersData",
                        new Gson().toJsonTree(
                                Arrays.stream(Bukkit.getOfflinePlayers()).map(offlinePlayer -> new Gson().toJson(new OfflinePlayerData(offlinePlayer)))
                        ).getAsJsonObject()
                        ).getJson());
                break;
            }
            case "getOnlinePlayers":{
                webSocket.send(new TypeData("onlinePlayersData",
                        new Gson().toJsonTree(
                                Bukkit.getOnlinePlayers().stream().map(player -> new Gson().toJson(new PlayerData(player)))
                        ).getAsJsonObject()
                ).getJson());
                break;
            }
        }
    }
}
