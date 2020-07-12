package com.atopom.leetcode.editor.cn;
// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
// 输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
// 输出: false
// 解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution98 {
    /**
     * @Description: 递归，中序遍历，升序
     * @Param: [root]
     * @Return: boolean
     * @Author: wangyanan
     * @Date: 21:12
     **/
    public boolean isValidBST(TreeNode root) {
        return traversal(root);
    }

    private long preValue = Long.MIN_VALUE;
    private boolean traversal(TreeNode root) {
        if (root == null) return true;
        if (!traversal(root.left)) {
            return false;
        }
        if (preValue >= root.val) return false;
        preValue = root.val;
        return traversal(root.right);
    }

    /**
     * @Description: 非递归，中序遍历，升序
     * @Param: [root]
     * @Return: boolean
     * @Author: wangyanan
     * @Date: 21:12
     **/
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        double preValue = Double.MIN_VALUE;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            if (node.val <= preValue) return false;
            preValue = node.val;
            curr = node.right;
        }
        return true;
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
