package com.hy.learn.base.offer;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 斐波拉契数列
 * @date 2021-04-12 22:39:57
 */
public class Num10 {

    static class Solution {
        public int fib(int n) {
            if(n <=1){
                return n;
            }

            int a = 0;
            int b = 1;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum = (a + b)%1000000007;
                a = b;
                b = sum;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int fib = solution.fib(200);
        System.out.println(fib);
    }

}
