package ru.aleons.reportcard.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {
    public String toHash(String data) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        String hash;
        m.reset();
        m.update(data.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        hash = bigInt.toString(16);
        while(hash.length() < 32 ){
            hash = "0"+hash;
        }
        return hash;
    }
}
