package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

public class WebSocketInfomation extends InfomationData {
    @SerializedName("worktime")
    public long worktime;
}
