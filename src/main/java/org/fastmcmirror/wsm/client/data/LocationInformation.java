package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class LocationInformation extends InformationData {
    @SerializedName("x")
    public double x;

    @SerializedName("y")
    public double y;

    @SerializedName("z")
    public double z;

    @SerializedName("yaw")
    public float yaw;

    @SerializedName("pitch")
    public float pitch;

    @SerializedName("world")
    public WorldInformation world;

    @SerializedName("chunk")
    public ChunkInformation chunk;
}
