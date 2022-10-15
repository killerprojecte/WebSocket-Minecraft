package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.PlayerPointsChangeInfomation;

public class PlayerPointsModifyPacket extends CommandPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public int count;
    public PlayerPointsChangeInfomation infomation;
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
        infomation = new Gson().fromJson(json, PlayerPointsChangeInfomation.class);
        future.complete(this);
        return this;
    }
}
