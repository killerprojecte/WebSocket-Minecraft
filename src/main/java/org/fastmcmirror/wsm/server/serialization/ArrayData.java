package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArrayData {
    public ArrayData(List<?> list){
        this.list = list;
    }

    @SerializedName("data")
    public List<?> list;
}
