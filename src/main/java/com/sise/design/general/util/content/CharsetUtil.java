package com.sise.design.general.util.content;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author :   Chen xuexin
 * @Time:     2019/7/19 20:37
 * @Descript: TODO
 * @Version:  1.0
 */


public class CharsetUtil {

    private static Pattern p = Pattern.compile("\\s*|\t|\r|\n|�|\u0005t| ");

    public  static String getString(String str, String charsetName) {
        if(str==null){
            return "";
        }
        try {
            str = new String(str.getBytes(charsetName), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String trim(String str) {
        String repl = "";
        if (str!=null) {
            Matcher m = CharsetUtil.p.matcher(str);
            repl = m.replaceAll("");
        }
        return repl;
    }

}
