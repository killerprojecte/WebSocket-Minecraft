package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

public class GetOfflinePlayerPacket {
    @SerializedName("name")
    public String name;

    public GetOfflinePlayerPacket(String name){
        this.name = name;
    }
}
