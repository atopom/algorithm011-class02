package com.atopom.leetcode.editor.cn;
// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
// 被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
// 输出：4
// 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
// 输出：12
// 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution198 {

    public int rob(int[] nums) {
        return helper1(nums, 0);
//        return helper2(nums);
//        return helper3(nums);
//        return helper4(nums);
    }

    // 暴力解题
    // nums[startIndex] + helper1(nums, startIndex + 2) 代表的是抢劫当前的房屋所累积的和
    // helper1(nums, startIndex) 代表的是不抢劫当前的房屋所累积的和
    private int helper1(int[] nums, int startIndex) {
        if (startIndex >= nums.length) return 0;
        return Math.max(nums[startIndex] + helper1(nums, startIndex + 2), helper1(nums, startIndex + 1));
    }

    // 动态规划
    // 1.重复子问题
        // bottom to up
    // 2.状态定义数组
        // dp[i][0..1] 使用升维缓存状态，0=i偷 1=i不偷
        // dp[0][0] = 0; // 不偷
        // dp[0][1] = nums[0]; // 偷
    // 3.DP方程
        // dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1])
        // dp[i][1] = dp[i - 1][0] + nums[i]
    private int helper2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 不偷
        dp[0][1] = nums[0]; // 偷

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // 动态规划
    // 1.重复子问题
        // bottom to up
    // 2.状态定义数组
        // 使用一维数组
        // dp[i]
    // 3.DP方程
        // dp[i] = Max(dp[i - 1], dp[i - 2] + nums[i])
    private int helper3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 动态规划
    // 1.重复子问题
        // bottom to up
    // 2.状态定义数组
        // 使用两个变量 替代 一维数组
        // prev = dp[i - 2]
        // curr = dp[i - 1]
    // 3.DP方程
        // temp = Max(curr, prev + nums[i])
    private int helper4(int[] nums) {
        int prev = 0; // dp[i - 2]
        int curr = 0; // dp[i - 1]

        for (int i : nums) {
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
//        int[] nums = new int[]{2, 7, 9, 3, 1};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{1, 2};
//        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(new Solution198().rob(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
