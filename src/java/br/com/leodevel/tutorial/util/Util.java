package br.com.leodevel.tutorial.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("MD5");
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

}
