package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import org.fastmcmirror.wsm.client.command.CommandSender;

public abstract class CommandPacket extends CommandSender {
    public String toJson() {
        return new Gson().toJson(this);
    }
}
