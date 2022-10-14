package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

public class PlayerPointsModifyPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public int count;

    public PlayerPointsModifyPacket(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
