package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommandExcutePacket {
    @SerializedName("commands")
    public List<String> commands;

    public CommandExcutePacket(List<String> list){
        commands = list;
    }
}
