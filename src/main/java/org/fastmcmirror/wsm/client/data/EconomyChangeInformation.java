package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class EconomyChangeInformation extends InformationData {
    @SerializedName("status")
    public boolean status;

    @SerializedName("has")
    public double has;

    @SerializedName("count")
    public double count;
}
