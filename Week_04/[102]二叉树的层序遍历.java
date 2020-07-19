package com.atopom.leetcode.editor.cn;
// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
// 二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution102 {

    private List<List<Integer>> result;

    /**
     * @Description: 递归法
     * @Param: [root]
     * @Return: java.util.List<java.util.List < java.lang.Integer>>
     * @Author: wangyanan
     * @Date: 10:22
     **/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        traversal(root, 0);
        return result;
    }

    private void traversal(TreeNode node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (node.left != null) traversal(node.left, level + 1);
        if (node.right != null) traversal(node.right, level + 1);
    }

    /**
     * @Description: 迭代法
     * @Param: [root]
     * @Return: java.util.List<java.util.List < java.lang.Integer>>
     * @Author: wangyanan
     * @Date: 10:25
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(item);
        }

        return result;
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
