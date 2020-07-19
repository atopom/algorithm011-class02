package com.atopom.leetcode.editor.cn;
// 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
// 的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
// 足越多数量的孩子，并输出这个最大数值。
//
// 注意： 
//
// 你可以假设胃口值为正。 
// 一个小朋友最多只能拥有一块饼干。
//
// 示例 1: 
//
// 
// 输入: [1,2,3], [1,1]
//
// 输出: 1
//
// 解释:
// 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
// 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
// 所以你应该输出1。
// 
//
// 示例 2: 
//
// 
// 输入: [1,2], [1,2,3]
//
// 输出: 2
//
// 解释:
// 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
// 你拥有的饼干数量和尺寸都足以让所有孩子满足。
// 所以你应该输出2.
// 
// Related Topics 贪心算法 


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution455 {

    /**
     * @Description: 贪心，从小到大
     * @Param: [g, s]
     * @Return: int
     * @Author: wangyanan
     * @Date: 22:58
     **/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        int[] g1 = new int[]{1, 2, 3};
        int[] s1 = new int[]{1, 1};
        System.out.println(solution455.findContentChildren(g1, s1));
        int[] g2 = new int[]{1, 2};
        int[] s2 = new int[]{1, 2, 3};
        System.out.println(solution455.findContentChildren(g2, s2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
