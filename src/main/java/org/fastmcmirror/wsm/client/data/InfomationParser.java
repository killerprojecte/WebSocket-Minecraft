package org.fastmcmirror.wsm.client.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.fastmcmirror.wsm.client.WebSocketClient;

import java.util.HashMap;
import java.util.Map;

public class InfomationParser {
    private static Map<String, Class<?>> infomationMap = new HashMap<>();

    public static void parse(JsonObject jsonObject) {
        String type = jsonObject.get("type").getAsString();
        if (!infomationMap.containsKey(type)) return;
        long syncId = jsonObject.get("syncId").getAsLong();
        if (!WebSocketClient.tasks.containsKey(syncId)) return;
        WebSocketClient.tasks.get(syncId).complete(new Gson().toJson(jsonObject.get("data")));
        WebSocketClient.tasks.remove(syncId);
    }

    public static void register(String type, Class<?> cl) {
        infomationMap.put(type, cl);
    }
}
