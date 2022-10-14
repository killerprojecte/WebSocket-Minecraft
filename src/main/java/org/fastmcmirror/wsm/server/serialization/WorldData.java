package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;
import org.bukkit.World;

public class WorldData {
    @SerializedName("worldType")
    public String worldType;
    @SerializedName("time")
    public long time;
    @SerializedName("seed")
    public long seed;
    @SerializedName("name")
    public String name;
    @SerializedName("pvp")
    public boolean pvp;
    @SerializedName("difficulty")
    public String difficulty;
    @SerializedName("gameRules")
    public String[] gameRules;

    public WorldData(World world) {
        worldType = world.getWorldType().getName();
        time = world.getTime();
        seed = world.getSeed();
        name = world.getName();
        pvp = world.getPVP();
        difficulty = world.getDifficulty().name();
        gameRules = world.getGameRules();
    }
}
