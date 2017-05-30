package com.ailtt.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by pengzhihao on 2017/5/30.
 */
public class EncodingTool {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
