package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

public class PlayerPointsChangedData {
    public PlayerPointsChangedData(boolean status,int has,int count){
        this.status = status;
        this.has = has;
        this.count = count;
    }

    @SerializedName("status")
    public boolean status;

    @SerializedName("has")
    public int has;

    @SerializedName("count")
    public int count;
}
