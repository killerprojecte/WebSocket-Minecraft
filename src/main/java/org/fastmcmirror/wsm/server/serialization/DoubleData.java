package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class DoubleData {
    public DoubleData(double data){
        this.data = data;
    }

    @SerializedName("data")
    public double data;
}
