package com.example.demo.web.modem.request_handlers;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class HexConverter {
    public static String convertHexString(String hex) {
        try {
            ByteBuffer buff = ByteBuffer.allocate(hex.length() / 2);
            for (int i = 0; i < hex.length(); i += 2) {
                buff.put((byte) Integer.parseInt(hex.substring(i, i + 2), 16));
            }
            buff.rewind();
            Charset cs = StandardCharsets.UTF_16;
            CharBuffer cb = cs.decode(buff);
            return cb.toString();
        } catch (Exception ex) {
            return null;
        }
    }
}
