package org.fastmcmirror.wsm.server.serialization;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArrayData {
    @SerializedName("data")
    public List<?> list;

    public ArrayData(List<?> list) {
        this.list = list;
    }
}
