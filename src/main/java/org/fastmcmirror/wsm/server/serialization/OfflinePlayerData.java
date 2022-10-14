package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public class OfflinePlayerData {
    public OfflinePlayerData(OfflinePlayer offlinePlayer){
        name = offlinePlayer.getName();
        uniqueId = offlinePlayer.getUniqueId();
        lastPlayed = offlinePlayer.getLastPlayed();
        firstPlayed = offlinePlayer.getFirstPlayed();
        location = new LocationData(offlinePlayer.getBedSpawnLocation());
    }

    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;

    @SerializedName("lastPlayed")
    public long lastPlayed;

    @SerializedName("firstPlayed")
    public long firstPlayed;

    @SerializedName("bedSpawnLocation")
    public LocationData location;
}
