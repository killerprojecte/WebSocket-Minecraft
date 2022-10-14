package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

public class EconomyModifyPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public double count;

    public EconomyModifyPacket(String name, double count) {
        this.name = name;
        this.count = count;
    }
}
