package com.atopom.leetcode.editor.cn;
// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int maxSubArray(int[] nums) {
//        return helper1(nums);
//        return helper2(nums);
        return helper3(nums);
    }

    // 暴力解法
    private int helper1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    // 动态规划
    // 分治（重复子问题） 最大子序和=当前元素自身最大 或者 加上之前的元素后最大
    // 状态数组定义 f[i]
    // dp方程 f[i] = Max(f[i - 1], 0) + nums[i]
    private int helper2(int[] nums) {
        int[] dp = nums.clone();
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }

    // 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
    // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    // 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    // 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
    // 时间复杂度：O(n)
    private int helper3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("result=" + new Solution53().maxSubArray(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
