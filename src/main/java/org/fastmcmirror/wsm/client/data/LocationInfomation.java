package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class LocationInfomation extends InfomationData {
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
    public WorldInfomation world;

    @SerializedName("chunk")
    public ChunkInfomation chunk;
}
