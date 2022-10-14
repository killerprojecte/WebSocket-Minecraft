package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChunkInfomation extends InfomationData{

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
    public WorldInfomation world;
}
