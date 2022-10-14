package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class BooleanData {
    @SerializedName("data")
    public boolean data;

    public BooleanData(boolean data) {
        this.data = data;
    }
}
