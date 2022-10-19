package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class PlayerInformation extends InformationData {
    @SerializedName("displayName")
    public String displayName;

    @SerializedName("name")
    public String name;

    @SerializedName("gamemode")
    public String gamemode;

    @SerializedName("health")
    public double health;

    @SerializedName("location")
    public LocationInformation location;

    @SerializedName("world")
    public WorldInformation world;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
