package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public class OfflinePlayerData {
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

    public OfflinePlayerData(OfflinePlayer offlinePlayer) {
        name = offlinePlayer.getName();
        uniqueId = offlinePlayer.getUniqueId();
        lastPlayed = offlinePlayer.getLastPlayed();
        firstPlayed = offlinePlayer.getFirstPlayed();
        if (offlinePlayer.getBedSpawnLocation() == null) {
            location = null;
        } else {
            location = new LocationData(offlinePlayer.getBedSpawnLocation());
        }
    }
}
