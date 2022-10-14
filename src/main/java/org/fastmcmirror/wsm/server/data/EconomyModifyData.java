package org.fastmcmirror.wsm.server.data;

import com.google.gson.annotations.SerializedName;

public class EconomyModifyData {
    @SerializedName("name")
    public String name;

    @SerializedName("count")
    public double count;
}
