package com.atopom.leetcode.editor.cn;
// 翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
//
// 输出： 
//
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
//
// 备注: 
// 这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution226 {
    /**
     * @Description: 递归
     * @Param: [root]
     * @Return: com.atopom.leetcode.editor.cn.Solution226.TreeNode
     * @Author: wangyanan
     * @Date: 20:47
     **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * @Description: 非递归
     * @Param: [root]
     * @Return: com.atopom.leetcode.editor.cn.Solution226.TreeNode
     * @Author: wangyanan
     * @Date: 20:48
     **/
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
