package com.atopom.leetcode.editor.cn;
// 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
//        return helper1(0, 0, triangle);
//        return helperDp(triangle);
        return helperDp2(triangle);
    }

    // 暴力
    private int helper1(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size()) return 0;
        return triangle.get(i).get(j) + Math.min(helper1(i + 1, j, triangle), helper1(i + 1, j + 1, triangle));
    }

    // 动态规划
    // 1.重复子问题 problem(i,j) = min(problem(i+1,j), problem(i+1,j+1)) + triangle[i,j]
    // 2.状态数组 f[i,j]
    // 3.dp方程 f[i,j] = min(f[i+1,j], f[i+1,j+1]) + triangle[i,j]
    private int helperDp(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        for (int i = triangle.size() - 2; i >= 0; i--) { // 倒数第2层开始
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer temp = triangle.get(i).get(j);
                temp += Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, temp);
            }
        }
        return triangle.get(0).get(0);
    }

    // 优化空间复杂度，降维，由helperDp推导
    private int helperDp2(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) { // 倒数第1层开始
            for (int j = 0; j < triangle.get(i).size(); j++) {
                a[j] = Math.min(a[j], a[j + 1]) + triangle.get(i).get(j);
            }
        }
        return a[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
