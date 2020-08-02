package com.atopom.leetcode.editor.cn;
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
// 输出: 3
// 解释:
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向右 -> 向下
// 2. 向右 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
// 输出: 28
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution62 {
    public int uniquePaths(int column, int row) {
        // 简化版
        int[] cur = new int[column];
        Arrays.fill(cur, 1);
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[column - 1];
    }

    public int uniquePaths2(int column, int row) {
        // 完整版
        int[][] map = new int[row][column];
        for (int i = 0; i < column; i++) map[0][i] = 1;
        for (int i = 0; i < row; i++) map[i][0] = 1;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[row - 1][column - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
