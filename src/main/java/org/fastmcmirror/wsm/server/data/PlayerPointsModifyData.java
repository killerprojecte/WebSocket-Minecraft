package org.fastmcmirror.wsm.server.data;

import com.google.gson.annotations.SerializedName;

public class PlayerPointsModifyData {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public int count;
}
