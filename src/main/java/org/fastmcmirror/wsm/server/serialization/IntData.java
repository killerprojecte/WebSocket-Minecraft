package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class IntData {
    @SerializedName("data")
    public int data;

    public IntData(int data) {
        this.data = data;
    }
}
