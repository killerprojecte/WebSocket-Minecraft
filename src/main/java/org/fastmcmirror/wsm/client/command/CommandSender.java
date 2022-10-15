package org.fastmcmirror.wsm.client.command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.fastmcmirror.wsm.client.packet.CommandPacket;

import java.util.concurrent.CompletableFuture;

import static org.fastmcmirror.wsm.client.WebSocketClient.tasks;
import static org.fastmcmirror.wsm.client.WebSocketClient.webSocket;

public abstract class CommandSender<T> {

    public CompletableFuture<T> future = new CompletableFuture<T>();

    public abstract CommandType getType();

    public abstract CommandPacket getPacket();

    public void send() {
        JsonObject json = new JsonObject();
        long syncId = SyncIdGenerator.next();
        json.addProperty("syncId", syncId);
        json.addProperty("commandId", getType().getName());
        json.add("data",
                new Gson().toJsonTree(getPacket()));
        webSocket.send(new Gson().toJson(json));
        tasks.put(syncId, this);
    }

    public abstract T complete(String json);
}
