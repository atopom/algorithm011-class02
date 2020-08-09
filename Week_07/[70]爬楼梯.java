package com.atopom.kata.leetcode.editor.cn;
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶
// 2.  2 阶
//
// 示例 2： 
//
// 输入： 3
// 输出： 3
// 解释： 有三种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶 + 1 阶
// 2.  1 阶 + 2 阶
// 3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

// 正整数：除0以外的自然数，1、2、3、4...
// 1    1
// 2    2   1 + 1
// 3    3   1 + 2
// f(n)=f(n-2)+f(n-1)


//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {
        // f(n) = f(n - 1) + f(n - 2)
        // 1.傻递归
        // return helper1(n);
        // 2.记忆化搜索
        // memo = new int[n + 1];
        // return helper2(n);
        // 3.动态规划 记忆化搜索
        // memo = new int[n + 1];
        // return helper3(n);
        // 4.动态规划 滚动数组
        return helper4(n);
    }

    private int helper1(int n) {
        if (n <= 1) return 1;
        return helper1(n - 1) + helper1(n - 2);
    }

    private int[] memo;

    private int helper2(int n) {
        if (n <= 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper2(n - 1) + helper2(n - 2);
        return memo[n];
    }

    private int helper3(int n) {
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    private int helper4(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            int temp = p + q;
            p = q;
            q = temp;
        }
        return q;
    }

    // 可以走1步、2步、3步，f(4) = f(3) + f(2) + f(1)
    // f(n) = f(n-1) + f(n-2) + f(n-3)
    private int[] memo2;

    public int climbStairs2(int n) {
        memo2 = new int[n + 1];
        memo2[1] = 1;
        memo2[2] = 2;
        memo2[3] = 3;
        for (int i = 4; i <= n; i++) {
            memo2[i] = memo2[i - 1] + memo2[i - 2] + memo2[i - 3];
        }
        return memo2[n];
    }

    // 可以走1步、2步、3步，但相邻两步的步伐不能相同
    // 状态数组定义 dp[i][j]定义成走到i级台阶用的步幅，此时j可以取 1  2  3
    // dp方程：
    // dp[i][1]=dp[i-1][2]+dp[i-1][3]
    // dp[i][2]=dp[i-2][1]+dp[i-2][3]
    // dp[i][3]=dp[i-3][2]+dp[i-3][1]
    //
    // 1 --> 1(1)
    // 2 --> 1(2)
    // 3 --> 3(3; 2,1; 1,2;)
    // 4 --> 3(3,1; 1,3; 1,2,1;)
    // 5 --> 4(3,2; 2,3; 2,1,2;)
    private int[][] memo3;
    public int climbStairs3(int n) {
        memo3 = new int[n + 1][1];
        memo3[1][1] = 1;
        memo3[2][2] = 1;
        memo3[3][1] = 3;
        memo3[3][2] = 2;
        memo3[3][3] = 1;
        for (int i = 4; i <= n; i++) {
            memo3[i][1] = memo3[i - 1][2] + memo3[i - 1][3];
            memo3[i][2] = memo3[i - 2][1] + memo3[i - 2][3];
            memo3[i][3] = memo3[i - 3][1] + memo3[i - 3][2];
        }
        return memo3[n][1] + memo3[n][2] + memo3[n][3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
