package com.hy.learn.base.offer;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-03-19 21:37:34
 */
public class Num05 {

    public static void main(String[] args) {
        String s = "hello world !";
        System.out.println("replaceSpace(s) = " + replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        int count = 0;
        for (int i =0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                count++;
            }
        }

        int length = count * 2 + s.length();
        char[] chars = s.toCharArray();
        char[] newChar = new char[length];

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                newChar[index] = '%';
                newChar[index+1] = '2';
                newChar[index+2] = '0';
                index = index + 3;
            }else {
                newChar[index] = chars[i];
                index ++;
            }
        }

        return new String(newChar);
    }

}
