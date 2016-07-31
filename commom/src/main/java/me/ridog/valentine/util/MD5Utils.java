package me.ridog.valentine.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by chan on 16/7/29.
 */
public class MD5Utils {

    /**
     * generate MD5
     *
     * @param src
     * @return
     * @throws Exception
     */
    public static String MD5(byte[] src) {
        try {
            if (src == null) {
                return "";
            }
            byte[] result = null;
            MessageDigest alg = MessageDigest.getInstance("MD5");
            result = alg.digest(src);
            return byte2hex(result);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String MD5(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            return MD5(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byte2hex(byte[] b) {
        if (b == null) {
            return "";
        }
        StringBuffer hs = new StringBuffer();
        String stmp = null;
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append("0");
            }
            hs.append(stmp);
        }
        return hs.toString();
    }
}
