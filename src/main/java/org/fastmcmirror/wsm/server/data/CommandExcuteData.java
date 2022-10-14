package org.fastmcmirror.wsm.server.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommandExcuteData {
    @SerializedName("commands")
    public List<String> commands;
}
