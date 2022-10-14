package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class PlayerPointsChangeInfomation extends InfomationData {
    @SerializedName("status")
    public boolean status;

    @SerializedName("has")
    public int has;

    @SerializedName("count")
    public int count;
}
