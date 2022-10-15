package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.EconomyChangeInfomation;

public class EconomyModifyPacket extends CommandPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public double count;
    public EconomyChangeInfomation infomation;
    private CommandType type;

    public EconomyModifyPacket(String name, double count, CommandType type) {
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
    public EconomyModifyPacket complete(String json) {
        infomation = new Gson().fromJson(json, EconomyChangeInfomation.class);
        future.complete(this);
        return this;
    }
}
