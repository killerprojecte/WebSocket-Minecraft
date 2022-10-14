package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.Chunk;
import org.bukkit.Location;

public class LocationData {
    public LocationData(Location location){
        x = location.getX();
        y = location.getY();
        z = location.getZ();
        yaw = location.getYaw();
        pitch = location.getPitch();
        world = new WorldData(location.getWorld());
        chunk = location.getChunk();
    }

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
    public WorldData world;

    @SerializedName("chunk")
    public Chunk chunk;
}
