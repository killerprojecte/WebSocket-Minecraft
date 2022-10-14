package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class StringData {
    @SerializedName("data")
    public String data;

    public StringData(String data) {
        this.data = data;
    }
}
