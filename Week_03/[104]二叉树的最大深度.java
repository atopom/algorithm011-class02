package com.atopom.leetcode.editor.cn;
// 给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
// 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution104 {
    /**
     * @Description: 递归，遍历 每层+1
     * @Param: [root]
     * @Return: int
     * @Author: wangyanan
     * @Date: 23:26
     **/
    public int maxDepth2(TreeNode root) {
        return traversal(root);
    }

    private int traversal(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = traversal(node.left);
        int rightDepth = traversal(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * @Description: 非递归，遍历 每层+1
     * @Param: [root]
     * @Return: int
     * @Author: wangyanan
     * @Date: 23:26
     **/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currPair = queue.poll();
            maxDepth = Math.max(maxDepth, currPair.getValue());
            if (currPair.getKey().left != null) queue.add(new Pair<>(currPair.getKey().left, currPair.getValue() + 1));
            if (currPair.getKey().right != null) queue.add(new Pair<>(currPair.getKey().right, currPair.getValue() + 1));
        }
        return maxDepth;
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
