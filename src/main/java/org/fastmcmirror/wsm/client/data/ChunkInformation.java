package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class ChunkInformation extends InformationData {

    @SerializedName("isLoaded")
    public boolean isLoaded;

    @SerializedName("x")
    public int x;

    @SerializedName("z")
    public int z;

    @SerializedName("isForceLoaded")
    public boolean isForceLoaded;

    @SerializedName("isSlimeChunk")
    public boolean isSlimeChunk;

    @SerializedName("world")
    public WorldInformation world;
}
