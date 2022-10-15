package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;

import java.util.List;

public class CommandExcutePacket extends CommandPacket {
    @SerializedName("commands")
    public List<String> commands;

    public CommandExcutePacket(List<String> list) {
        commands = list;
    }

    @Override
    public CommandType getType() {
        return CommandType.EXCUTE_COMMAND;
    }

    @Override
    public CommandPacket getPacket() {
        return this;
    }

    @Override
    public CommandExcutePacket complete(String json) {
        future.complete(this);
        return this;
    }
}
