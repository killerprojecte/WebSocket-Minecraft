package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerData {
    public PlayerData(Player player){
        displayName = player.getDisplayName();
        name = player.getName();
        gamemode = player.getGameMode().toString();
        health = player.getHealth();
        location = new LocationData(player.getLocation());
        world = new WorldData(player.getWorld());
        uniqueId = player.getUniqueId();
    }

    @SerializedName("displayName")
    public String displayName;

    @SerializedName("name")
    public String name;

    @SerializedName("gamemode")
    public String gamemode;

    @SerializedName("health")
    public double health;

    @SerializedName("location")
    public LocationData location;

    @SerializedName("world")
    public WorldData world;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
