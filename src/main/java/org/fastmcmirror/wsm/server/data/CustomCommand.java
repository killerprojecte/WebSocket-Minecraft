package org.fastmcmirror.wsm.server.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class CustomCommand {
    public abstract JsonObject run(JsonElement data);
}
