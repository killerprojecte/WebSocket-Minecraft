package org.fastmcmirror.wsm.client.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class InfomationParser {
    public static InfomationData lastParsed;
    private static Map<String, Class<?>> infomationMap = new HashMap<>();

    public static void parse(JsonObject jsonObject) {
        String type = jsonObject.get("type").getAsString();
        if (!infomationMap.containsKey(type)) return;
        lastParsed = (InfomationData) new Gson().fromJson(jsonObject.get("data"), infomationMap.get(type));
    }

    public static void register(String type, Class<?> cl) {
        infomationMap.put(type, cl);
    }
}
