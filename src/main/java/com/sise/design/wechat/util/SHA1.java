package com.sise.design.wechat.util;

import java.security.MessageDigest;

/**
 * Created by IntelliJ IDEA.
 * user:      Chen xuexin
 * Time:      2019/7/15 0:16
 * Class:     SHA1
 * Descript:  TODO
 * Version:   1.0
 */

public final class SHA1 {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     * user:    Chen xuexin
     * Time:    2019/7/15 0:16
     * @param   bytes  the raw bytes from the digest.
     * @return  String the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for ( byte val : bytes ){
            buf.append(HEX_DIGITS[(val >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[ val & 0x0f]);
        }
        return buf.toString();
    }

    /**
     *
     * user:    Chen xuexin
     * Time:    2019/7/15 0:17
     * @param   str  String
     * @return  String
     */
    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

