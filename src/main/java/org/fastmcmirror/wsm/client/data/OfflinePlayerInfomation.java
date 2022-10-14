package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class OfflinePlayerInfomation extends InfomationData {
    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;

    @SerializedName("lastPlayed")
    public long lastPlayed;

    @SerializedName("firstPlayed")
    public long firstPlayed;

    @SerializedName("bedSpawnLocation")
    public LocationInfomation location;
}
