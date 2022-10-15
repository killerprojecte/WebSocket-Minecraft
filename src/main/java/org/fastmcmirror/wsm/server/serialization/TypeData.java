package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class TypeData {
    @SerializedName("type")
    public String type;
    @SerializedName("data")
    public JsonElement data;
    @SerializedName("syncId")
    public long syncId;

    public TypeData(String type, JsonElement data, long syncId) {
        this.type = type;
        this.data = data;
        this.syncId = syncId;
    }

    public String getJson() {
        return new Gson().toJson(this);
    }
}
