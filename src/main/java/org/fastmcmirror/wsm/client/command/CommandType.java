package org.fastmcmirror.wsm.client.command;

public enum CommandType {
    SERVER_INFO("serverInfo"),
    EXCUTE_COMMAND("commandExcute"),
    GET_OFFLINE_PLAYER("getOfflinePlayer"),
    GET_PLAYER("getPlayer"),
    GET_OFFLINE_PLAYERS("getOfflinePlayers"),
    GET_ONLINE_PLAYERS("getOnlinePlayers"),
    GET_PLAYERPOINTS("getPlayerPoints"),
    TAKE_PLAYERPOINTS("takePlayerPoints"),
    GIVE_PLAYERPOINTS("givePlayerPoints"),
    SET_PLAYERPOINTS("setPlayerPoints"),
    GET_ECONOMY("getEconomy"),
    TAKE_ECONOMY("takeEconomy"),
    GIVE_ECONOMY("giveEconomy"),
    SET_ECONOMY("setEconomy"),
    HAS_PERMISSION("hasPermission"),
    PARSE_PLACEHOLDER("parsePlaceholder");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
