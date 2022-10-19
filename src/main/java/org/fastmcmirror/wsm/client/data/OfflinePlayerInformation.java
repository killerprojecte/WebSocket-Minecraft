package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class OfflinePlayerInformation extends InformationData {
    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;

    @SerializedName("lastPlayed")
    public long lastPlayed;

    @SerializedName("firstPlayed")
    public long firstPlayed;

    @SerializedName("bedSpawnLocation")
    public LocationInformation location;
}
