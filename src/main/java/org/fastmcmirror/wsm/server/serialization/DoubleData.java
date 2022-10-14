package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class DoubleData {
    @SerializedName("data")
    public double data;

    public DoubleData(double data) {
        this.data = data;
    }
}
