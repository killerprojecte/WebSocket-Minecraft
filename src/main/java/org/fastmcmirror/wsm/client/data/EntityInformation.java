package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class EntityInformation extends InformationData {
    @SerializedName("world")
    public WorldInformation world;

    @SerializedName("type")
    public String type;

    @SerializedName("location")
    public LocationInformation location;

    @SerializedName("customName")
    public String customName;

    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
