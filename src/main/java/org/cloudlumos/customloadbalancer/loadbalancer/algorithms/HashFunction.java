package org.cloudlumos.customloadbalancer.loadbalancer.algorithms;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {
    private MessageDigest md;

    public HashFunction() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public int hash(String key) {
        byte[] digest = md.digest(key.getBytes(StandardCharsets.UTF_8));
        return ((digest[3] & 0xFF) << 24) | ((digest[2] & 0xFF) << 16) | ((digest[1] & 0xFF) << 8) | (digest[0] & 0xFF);
    }
}
