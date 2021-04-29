package com.hy.learn.base.algorithm;

/**
 * @author Created by hy
 * @date on 2021/4/29 19:09
 */
public class Geek15 {

    //这节课主要讲的二分查找的问题

    /**
     *
     * @param a 待查找数组，数组有序且无重复值
     * @param n 数组长度
     * @param value 待查找的值
     * @return
     */
    public static int bsearch(int[] a, int n, int value){

        int low = 0;
        int high = n -1;

        for(int i = 0; i < n-1; i++){

            if (low <= high){

                int mid = low + (high-low) / 2;

                if(a[mid] == value){
                    return mid;
                }
                if(a[mid] > value){
                    high = mid -1;
                }
                if(a[mid] < value){
                     low = mid +1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9,100,200};
        int bsearch = bsearch(a, 12, 200);
        System.out.println("bsearch = " + bsearch);
    }
}
