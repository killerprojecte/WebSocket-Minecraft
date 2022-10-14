package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class BooleanData {
    public BooleanData(boolean data){
        this.data = data;
    }

    @SerializedName("data")
    public boolean data;
}
