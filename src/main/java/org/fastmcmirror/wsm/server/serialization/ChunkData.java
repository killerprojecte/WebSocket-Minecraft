package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.Chunk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChunkData {
    public ChunkData(Chunk chunk){
        entities = Arrays.stream(chunk.getEntities()).map(entity -> new EntityData(entity)).collect(Collectors.toList());
        isLoaded = chunk.isLoaded();
        x = chunk.getX();
        z = chunk.getZ();
        isForceLoaded = chunk.isForceLoaded();
        isSlimeChunk = chunk.isSlimeChunk();
        world = new WorldData(chunk.getWorld());
    }

    @SerializedName("entitys")
    public List<EntityData> entities;

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
}
