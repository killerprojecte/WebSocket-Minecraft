package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.BooleanInformation;

public class HasPermissionPacket extends CommandPacket {
    @SerializedName("world")
    public String world;

    @SerializedName("name")
    public String name;

    @SerializedName("permission")
    public String permission;
    public BooleanInformation information;

    public HasPermissionPacket(String world, String name, String permission) {
        this.world = world;
        this.name = name;
        this.permission = permission;
    }

    @Override
    public CommandType getType() {
        return CommandType.HAS_PERMISSION;
    }

    @Override
    public CommandPacket getPacket() {
        return this;
    }

    @Override
    public HasPermissionPacket complete(String json) {
        information = new Gson().fromJson(json, BooleanInformation.class);
        future.complete(this);
        return this;
    }
}
