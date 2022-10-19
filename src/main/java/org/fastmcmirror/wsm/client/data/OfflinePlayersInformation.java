package org.fastmcmirror.wsm.client.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OfflinePlayersInformation extends InformationData {
    @SerializedName("data")
    public List<OfflinePlayerInformation> data;
}
