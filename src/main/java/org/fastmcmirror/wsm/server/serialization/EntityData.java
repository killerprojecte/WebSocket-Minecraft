package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class EntityData {
    public EntityData(Entity entity){
        world = new WorldData(entity.getWorld());
        type = entity.getType().toString();
        location = new LocationData(entity.getLocation());
        customName = entity.getCustomName();
        name = entity.getName();
        uniqueId = entity.getUniqueId();
    }

    @SerializedName("world")
    public WorldData world;

    @SerializedName("type")
    public String type;

    @SerializedName("location")
    public LocationData location;

    @SerializedName("customName")
    public String customName;

    @SerializedName("name")
    public String name;

    @SerializedName("uniqueId")
    public UUID uniqueId;
}
