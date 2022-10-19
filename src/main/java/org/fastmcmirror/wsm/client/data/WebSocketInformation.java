package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class WebSocketInformation extends InformationData {
    @SerializedName("worktime")
    public long worktime;
}
