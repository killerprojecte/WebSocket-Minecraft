package org.fastmcmirror.wsm.client.packet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.fastmcmirror.wsm.client.command.CommandType;
import org.fastmcmirror.wsm.client.data.StringInformation;

public class PlaceholderParsePacket extends CommandPacket {
    @SerializedName("name")
    public String name;

    @SerializedName("placeholder")
    public String placeholder;
    public StringInformation information;

    public PlaceholderParsePacket(String name, String placeholder) {
        this.name = name;
        this.placeholder = placeholder;
    }

    @Override
    public CommandType getType() {
        return CommandType.PARSE_PLACEHOLDER;
    }

    @Override
    public CommandPacket getPacket() {
        return this;
    }

    @Override
    public PlaceholderParsePacket complete(String json) {
        information = new Gson().fromJson(json, StringInformation.class);
        future.complete(this);
        return this;
    }
}
