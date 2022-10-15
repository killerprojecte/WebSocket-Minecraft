package org.fastmcmirror.wsm.client.command;

public class SyncIdGenerator {
    private static long syncId = 0L;

    public static long next() {
        return syncId++;
    }
}
