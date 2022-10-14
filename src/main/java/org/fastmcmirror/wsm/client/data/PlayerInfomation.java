package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class PlayerInfomation extends InfomationData{
    @SerializedName("displayName")
    public String displayName;

    @SerializedName("name")
    public String name;

    @SerializedName("gamemode")
    public String gamemode;

    @SerializedName("health")
    public double health;

    @SerializedName("location")
    public LocationInfomation location;

    @SerializedName("world")
    public WorldInfomation world;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
