package org.fastmcmirror.wsm.server.data;

import com.google.gson.annotations.SerializedName;

public class HasPermissionData {
    @SerializedName("world")
    public String world;

    @SerializedName("name")
    public String name;

    @SerializedName("permission")
    public String permission;
}
