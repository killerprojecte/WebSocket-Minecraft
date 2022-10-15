package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.*;

public class GetOfflinePlayerPacket extends CommandPacket {
    @SerializedName("name")
    public String name;
    public InfomationData infomation;
    private CommandType type;

    public GetOfflinePlayerPacket(String name, CommandType type) {
        this.name = name;
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
    public GetOfflinePlayerPacket complete(String json) {
        Class<?> cls = null;
        if (type == CommandType.GET_OFFLINE_PLAYER) {
            cls = OfflinePlayerInfomation.class;
        } else if (type == CommandType.GET_PLAYER) {
            cls = PlayerInfomation.class;
        } else if (type == CommandType.GET_PLAYERPOINTS) {
            cls = IntInfomation.class;
        } else if (type == CommandType.GET_ECONOMY) {
            cls = DoubleInfomation.class;
        }
        infomation = (InfomationData) new Gson().fromJson(json, cls);
        future.complete(this);
        return this;
    }
}
