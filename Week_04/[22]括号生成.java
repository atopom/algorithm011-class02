package com.atopom.leetcode.editor.cn;
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
// 输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    private void generate(int n, int left, int right, String s, List<String> list) {
        if (left == n && right == n) {
            System.out.println(s);
            list.add(s);
            return;
        }
        // 剪去无效分支的操作：减支
        // 1.左括号无限制，只要小于n就可以
        if (left < n) generate(n, left + 1, right, s + "(", list);
        // 2.右括号有一个边界条件，就是必须有左括号的情况下才能加右括号
        if (right < n && left > right) generate(n, left, right + 1, s + ")", list);
    }

    public static void main(String[] args) {
        new Solution22().generateParenthesis(3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
