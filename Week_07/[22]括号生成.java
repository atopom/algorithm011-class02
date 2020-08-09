package com.atopom.kata.leetcode.editor.cn;
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
        helper(n, 0, 0, "", result);
        return result;
    }

    // 递归+剪枝
    private void helper(int n, int left, int right, String str, ArrayList<String> result) {
        // 递归终止条件
        if (left == n && right == n) result.add(str);
        // 剪枝
        // 1.左括号只要不满就能加
        if (left < n) helper(n, left + 1, right, str + "(", result);
        // 2.右括号个数不能大于左括号个数 或者 右括号不满 就能加
        if (right < left && right < n) helper(n, left, right + 1, str + ")", result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
