package com.atopom.leetcode.editor.cn;
// 给定一个二叉树，返回它的中序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
// 输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
class Solution94 {
    /**
     * @Description: 非递归
     * @Param: [root]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: wangyanan
     * @Date: 13:47
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    /**
     * @Description: 递归
     * @Param: [root]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: wangyanan
     * @Date: 13:54
     **/
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (node.left != null) {
            traversal(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            traversal(node.right, list);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
//        root.left = new TreeNode(4);
        root.right = right;
        root.right.left = left;
//        List<Integer> integers = new Solution94().inorderTraversal(root);
        List<Integer> integers = new Solution94().inorderTraversal2(root);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
