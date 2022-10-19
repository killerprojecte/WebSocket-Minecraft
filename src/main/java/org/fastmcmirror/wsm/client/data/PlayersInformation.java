package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayersInformation extends InformationData {
    @SerializedName("data")
    public List<PlayerInformation> data;
}
