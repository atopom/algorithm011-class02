package com.atopom.leetcode.editor.cn;
// 给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)


import javafx.util.Pair;

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
class Solution111 {
    /**
     * @Description: 递归
     * @Param: [root]
     * @Return: int
     * @Author: wangyanan
     * @Date: 8:19 上午
     **/
    public int minDepth2(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (node.left != null) minDepth = Math.min(minDepth, helper(node.left));
        if (node.right != null) minDepth = Math.min(minDepth, helper(node.right));
        return minDepth + 1;
    }

    /**
     * @Description: 遍历 BFS 广度优先
     * @Param: [root]
     * @Return: int
     * @Author: wangyanan
     * @Date: 1:53 下午
     **/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minDepth = 1;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = queue.poll();
            TreeNode left = nodePair.getKey().left;
            TreeNode right = nodePair.getKey().right;
            minDepth = nodePair.getValue();
            if (left == null && right == null) break;
            if (left != null) queue.add(new Pair<>(left, minDepth + 1));
            if (right != null) queue.add(new Pair<>(right, minDepth + 1));
        }
        return minDepth;
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
