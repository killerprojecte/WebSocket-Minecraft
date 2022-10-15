package org.fastmcmirror.wsm.server.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.fastmcmirror.wsm.server.serialization.TypeData;
import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class CustomParser {
    private static Map<String, CustomCommand> commands = new HashMap<>();

    protected static void parse(WebSocket socket, String type, long syncId, JsonElement data) {
        if (!commands.containsKey(type)) return;
        JsonObject object = commands.get(type).run(data);
        socket.send(new TypeData(type, object, syncId).getJson());
    }

    public static void register(String type, CustomCommand command) {
        commands.put(type, command);
    }
}
