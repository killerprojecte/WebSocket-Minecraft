package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class EconomyChangedData {
    public EconomyChangedData(boolean status, double has, double count){
        this.status = status;
        this.has = has;
        this.count = count;
    }

    @SerializedName("status")
    public boolean status;

    @SerializedName("has")
    public double has;

    @SerializedName("count")
    public double count;
}
