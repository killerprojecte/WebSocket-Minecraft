package org.fastmcmirror.wsm.server.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CommandParserData {
    @SerializedName("commandId")
    public String commandId;

    @SerializedName("data")
    public JsonObject data;
}
