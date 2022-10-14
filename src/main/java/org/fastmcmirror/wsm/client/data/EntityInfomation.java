package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class EntityInfomation extends InfomationData {
    @SerializedName("world")
    public WorldInfomation world;

    @SerializedName("type")
    public String type;

    @SerializedName("location")
    public LocationInfomation location;

    @SerializedName("customName")
    public String customName;

    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
