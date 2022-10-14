package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OfflinePlayersInfomation extends InfomationData{
    @SerializedName("data")
    public List<OfflinePlayerInfomation> data;
}
