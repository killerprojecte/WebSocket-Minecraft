package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class TypeData {
    public TypeData(String type,JsonElement data){
        this.type = type;
        this.data = data;
    }

    @SerializedName("type")
    public String type;

    @SerializedName("data")
    public JsonElement data;

    public String getJson(){
        return new Gson().toJson(this);
    }
}
