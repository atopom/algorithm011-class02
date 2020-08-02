package com.atopom.leetcode.editor.cn;
// 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
// F(0) = 0,   F(1) = 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
// 输出：1
// 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
// 输出：2
// 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
// 输出：3
// 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {

    public int fib(int N) {
//        return helper1(N);
//        cache = new int[N + 1];
//        return helper2(N);
//        return helper3(N);
        return helper4(N);
    }

    // 傻递归
    private int helper1(int N) {
        return N <= 1 ? N : fib(N - 1) + fib(N - 2);
    }

    // 记忆化搜索
    int[] cache;

    private int helper2(int N) {
        if (N <= 1) return N;
        if (cache[N] != 0) return cache[N];
        cache[N] = helper2(N - 1) + helper2(N - 2);
        return cache[N];
    }

    // 动态规划 bottom to up
    // 从1到N，使用循环迭代完成计算
    // 状态转移方程 f(n) = f(n - 1) + f(n - 2)，n > 2
    // 你把 f(n) 想做一个状态 n，这个状态 n 是由状态 n - 1 和状态 n - 2 相加转移而来，这就叫状态转移，仅此而已
    private int helper3(int N) {
        if (N <= 1) return N;
        int[] cache = new int[N + 1];
        cache[1] = cache[2] = 1;
        for (int i = 3; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

    // 根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
    // 优化空间复杂度为O(1)
    private int helper4(int N) {
        if (N <= 1) return N;
        int prev = 1, curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
