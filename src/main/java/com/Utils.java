package com;

import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.services.Response;
import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;

public class Utils {
    public static byte[] uuid2Bytes(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        return buffer.array();
    }
    
    public static UUID bytes2Uuid(byte [] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return new UUID(buffer.getLong(), buffer.getLong());
    }

    public static StreamResponse bytes2Image(final byte [] bytes) {
        return new StreamResponse() {
            public String getContentType() {
                return "image/png";
            }

            public InputStream getStream() throws IOException {
                return new ByteArrayInputStream(bytes);
            }

            public void prepareResponse(Response response) {
                // add response headers if you need to here
            }
        };
    }
    public static byte[] defaultImg() {
        byte[] bytes = null;
        try {

            bytes = IOUtils.readFully(new FileInputStream("/tmp/books.png"), -1, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
