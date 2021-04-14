package com.hy.learn.base.algorithm;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 排序算法
 * @date 2021-04-13 21:51:36
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * @param a 数组
     * @param n 数组大小
     */
    static int[] bubbleSort(int[] a, int n) {

        for (int i = 0; i < n; i++) {
            for (int m = 0; m < n -1 - i; m++) {
                if (a[m] > a[m + 1]) {
                    int temp = a[m+1];
                    a[m + 1] = a[m];
                    a[m] = temp;
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {3,4,2,5,6,1};
        int[] ints = bubbleSort(a, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(a[i]);
        }
    }

}
