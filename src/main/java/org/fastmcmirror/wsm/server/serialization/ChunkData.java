package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.Chunk;

public class ChunkData {
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
    public WorldData world;

    public ChunkData(Chunk chunk) {
        isLoaded = chunk.isLoaded();
        x = chunk.getX();
        z = chunk.getZ();
        isForceLoaded = chunk.isForceLoaded();
        isSlimeChunk = chunk.isSlimeChunk();
        world = new WorldData(chunk.getWorld());
    }
}
