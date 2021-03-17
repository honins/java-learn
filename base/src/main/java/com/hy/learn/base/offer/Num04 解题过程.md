# 剑指 Offer 04. 二维数组中的查找 难度中等

## 题目
```
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：

0 <= n <= 1000

0 <= m <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```
## 解题

### 第一反应穷举

第一反应就是穷举，当然能结果，就是不知道能beat多少，很快就能写出来
```
static boolean findNumberIn2DArrayWay1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++){
            for (int n = 0; n < matrix[i].length; n++) {
                if (matrix[i][n] == target){
                    return true;
                }
            }
        }
        return false;
    }
```

结果
```
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：44.4 MB, 在所有 Java 提交中击败了17.55%的用户
```
很明显，内容消耗太大，于是想其他方法

### 以右上角为起始点 temp，若大于temp 则column++，若小于 temp 则row--
思路还算比较简单，但是作为DS新手，写起来还算挺多坑的。
经过一个多小时的摸索，写出来这个
```
 static boolean findNumberIn2DArrayWay2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int column = matrix.length -1;

        while (column >= 0 && row < matrix.length){
            int temp = matrix[row][column];
            if (target == temp){
                return true;
            }
            if (target < temp){
                column--;
            }
            if (target > temp){
                row++;
            }
        }
        return false;
    }
```
提交后发现 入参为 `[[-1,3]]`报错
觉得很奇怪报错在哪

结果发现自己错的很离谱，因为测试数据是 row == column的，所以没发现
column 初始值应该是`matrix[0].length -1` 而不是`matrix.length -1`

于是应该是这样
```
static boolean findNumberIn2DArrayWay2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int column = matrix[0].length -1;

        while (column >= 0 && row < matrix.length){
            int temp = matrix[row][column];
            if (target == temp){
                return true;
            }
            if (target < temp){
                column--;
            }
            if (target > temp){
                row++;
            }
        }
        return false;
    }
```
提交结果
```
结果
```
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：43.9 MB, 在所有 Java 提交中击败了95.49%的用户
```

可见0.5这么小的内存，就超过了大部分人。