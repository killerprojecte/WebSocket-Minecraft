package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class IntData {
    public IntData(int data){
        this.data = data;
    }

    @SerializedName("data")
    public int data;
}
