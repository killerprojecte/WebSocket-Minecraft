package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class WorldInformation extends InformationData {
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
}
