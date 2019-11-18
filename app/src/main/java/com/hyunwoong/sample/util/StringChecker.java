package com.hyunwoong.sample.util;

/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오후 4:32
 * @homepage : https://github.com/gusdnd852
 */
public class StringChecker {

    public static boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    public static boolean isShort(String str, int min) {
        return str.length() < min;
    }
}
