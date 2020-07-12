package com.atopom.leetcode.editor.cn;
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
    /**
     * @Description: 动态规划 滚动数组思想
     * @Param: [n]
     * @Return: int
     * @Author: wangyanan
     * @Date: 22:51
     **/
    public int climbStairs2(int n) {
        int r = 1, p = 1, q = 1; // i = 1
        for (int i = 2; i <= n; i++) { // 正整数
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * @Description: 递归
     * @Param: [n]
     * @Return: int
     * @Author: wangyanan
     * @Date: 22:57
     **/
    public int climbStairs(int n) {
        if (n < 1) return 0;
        return fibonacci(n, 1, 1);
    }

    private int fibonacci(int n, int f1, int f2) {
        if (n == 1) {
            return f2;
        }
        return fibonacci(n - 1, f2, f1 + f2);
    }

    public static void main(String[] args) {
        int count = new Solution70().climbStairs(5);
//        int count = new Solution70().climbStairs2(5);
        System.out.println(count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
