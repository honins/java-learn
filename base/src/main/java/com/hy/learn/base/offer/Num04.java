package com.hy.learn.base.offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author home-pc
 * @program: java-learn
 * @description: 剑指offer 04
 * @date 2021-03-17 19:32:44
 */
public class Num04 {

    public static void main(String[] args) {

//        int[][] matrix = {{1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
//        int[][] matrix = {{}};
        int[][] matrix = {{-1 , 3}};
        boolean numberIn2DArray = findNumberIn2DArrayWay2(matrix, 3);
        System.out.println("numberIn2DArray = " + numberIn2DArray);

    }
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

}
