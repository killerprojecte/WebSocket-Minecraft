package org.fastmcmirror.wsm.client.packet;

import com.google.gson.annotations.SerializedName;

public class PlaceholderParsePacket {
    @SerializedName("name")
    public String name;

    @SerializedName("placeholder")
    public String placeholder;

    public PlaceholderParsePacket(String name,String placeholder){
        this.name = name;
        this.placeholder = placeholder;
    }
}
