package org.fastmcmirror.wsm.client.data;

import com.google.gson.Gson;

public abstract class InfomationData {
    public String toJson(){
        return new Gson().toJson(this);
    }
}
