package com;

import java.nio.ByteBuffer;
import java.util.UUID;

public class Utils {
    public static byte[] uuid2Bytes(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        return buffer.array();
    }
}
