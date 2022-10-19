package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class PlayerPointsChangeInformation extends InformationData {
    @SerializedName("status")
    public boolean status;

    @SerializedName("has")
    public int has;

    @SerializedName("count")
    public int count;
}
