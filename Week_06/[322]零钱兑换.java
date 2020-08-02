package com.atopom.leetcode.editor.cn;
// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
// 输出: 3
// 解释: 11 = 5 + 5 + 1
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
// 输出: -1
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 


import java.util.Arrays;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {

    public int coinChange(int[] coins, int amount) {
//        if (amount == 0 || coins == null || coins.length == 0) return 0;
//        // 升序排序 硬币
//        Integer[] coinsBox = Arrays.stream(coins).boxed().toArray(Integer[]::new);
//        Arrays.sort(coinsBox, Collections.reverseOrder());
//        coins = Arrays.stream(coinsBox).mapToInt(Integer::intValue).toArray();
//        helper(coins, amount, 0, 0);
//        return result != Integer.MAX_VALUE ? result : -1;
//        return helperDp(coins, amount);
//        memo = new int[amount + 1];
//        return helperDp2(coins, amount);
        return helperDp3(coins, amount);
    }

    // 贪心&递归
    int result = Integer.MAX_VALUE;

    private void helper(int[] coins, int amount, int index, int count) {
        // 递归结束条件
        if (amount == 0) {
            result = Math.min(result, count);
            return;
        }
        if (coins.length == index) return;
        // 递归处理当前层逻辑
        int k = amount / coins[index]; // 需要k个index的硬币
        for (; k >= 0 && count + k < result; k--) { // 投递[0,k]个index的硬币
            // 递归进入下一层
            helper(coins, amount - k * coins[index], index + 1, count + k);
        }
    }

    // 动态规划 top to bottom
    // 从 n 到 0
    // 1.确定 base case： 目标金额 amount == 0 时，返回0
    // 2.确定 状态：原问题和子问题中会变化的量 目标金额 amount
    // 3.确定 选择：也就是导致 状态 变化的行为 选择不同的硬币，会让目标金额减少
    // 4.明确 dp函数的定义 dp(n) 输入一个目标金额 n，返回凑出目标金额 n 的最少硬币数量。
    // 5.dp方程 dp(n) = min(result, dp(n - coin))
    private int helperDp(int[] coins, int n) {
        if (n == 0) return 0;
        if (n < 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = helperDp(coins, n - coin);
            if (subproblem == -1) continue;
            result = Math.min(result, subproblem + 1);
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    private int[] memo;

    private int helperDp2(int[] coins, int n) {
        if (memo[n] != 0) return memo[n];
        if (n == 0) return 0;
        if (n < 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = helperDp(coins, n - coin);
            if (subproblem == -1) continue;
            result = Math.min(result, subproblem + 1);
        }
        memo[n] = result == Integer.MIN_VALUE ? -1 : result;
        return memo[n];
    }

    // 动态规划 bottom to up
    // 从 0 到 n
    // 1.确定 base case： 目标金额 amount == 0 时，返回0
    // 2.确定 状态：原问题和子问题中会变化的量 目标金额 amount
    // 3.确定 选择：也就是导致 状态 变化的行为 选择不同的硬币，会让目标金额减少
    // 4.明确 dp数组的定义 dp[n] 当目标金额为 i 时，至少需要 dp[i] 枚。
    // 5.dp方程 dp[n] = min(dp[i], dp(i - coin) + 1)
    private int helperDp3(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution322().coinChange(coins, 11));
        int[] coins2 = {2};
        System.out.println(new Solution322().coinChange(coins2, 3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
