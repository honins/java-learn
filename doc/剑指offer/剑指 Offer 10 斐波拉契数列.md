# 题目

https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

# 思路

第一反应当然是递归，写出来很轻松
然而提交后未通过，显示 `超出时间限制`
也就是n较大时需要耗费大量时间计算，时间复杂度On方

随后查一下其他解法。发现使用动态规划是最合适的

>递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。

考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。

# 解题

```java

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

```