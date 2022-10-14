package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayersInfomation extends InfomationData {
    @SerializedName("data")
    public List<PlayerInfomation> data;
}
