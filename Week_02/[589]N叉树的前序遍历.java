package com.atopom.leetcode.editor.cn;
// 给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;

class Solution589 {
    /**
     * @Description: 非递归
     * @Param: [root]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: wangyanan
     * @Date: 17:08
     **/
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.push(item);
            }
        }
        return result;
    }

    /**
     * @Description: 递归
     * @Param: [root]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: wangyanan
     * @Date: 17:08
     **/
    public List<Integer> preorder2(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node item : node.children) {
            traversal(item, list);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
