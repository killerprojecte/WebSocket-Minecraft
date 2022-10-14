package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

public class HasPermissionPacket {
    @SerializedName("world")
    public String world;

    @SerializedName("name")
    public String name;

    @SerializedName("permission")
    public String permission;

    public HasPermissionPacket(String world,String name,String permission){
        this.world = world;
        this.name = name;
        this.permission = permission;
    }
}
