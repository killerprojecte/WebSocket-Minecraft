package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.PlayerPointsChangeInformation;

public class PlayerPointsModifyPacket extends CommandPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public int count;
    public PlayerPointsChangeInformation information;
    private CommandType type;

    public PlayerPointsModifyPacket(String name, int count, CommandType type) {
        this.name = name;
        this.count = count;
        this.type = type;
    }

    @Override
    public CommandType getType() {
        return type;
    }

    @Override
    public CommandPacket getPacket() {
        return this;
    }

    @Override
    public PlayerPointsModifyPacket complete(String json) {
        information = new Gson().fromJson(json, PlayerPointsChangeInformation.class);
        future.complete(this);
        return this;
    }
}
