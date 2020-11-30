package com.hy.learn.base.offer;

import org.junit.Test;

/**
 * @author home-pc
 * @program: java
 * @description:
 * @date 2020-11-22 13:05:01
 */
public class Num05Test {

    @Test
    public void main() {
        String s = replaceSpace("asd' 'asdsad");
        System.out.println(s);
    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int appendLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                appendLength += 2;
            }
        }
        char[] buff = new char[chars.length + appendLength];
        int m = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                buff[m] = "%".charAt(0);
                buff[m + 1] = "2".charAt(0);
                buff[m + 2] = "0".charAt(0);
                m = m + 3;
            } else {
                buff[m] = chars[i];
                m += 1;
            }
        }
        return new String(buff);
    }

}
