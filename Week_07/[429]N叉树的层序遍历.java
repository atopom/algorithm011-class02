package com.atopom.kata.leetcode.editor.cn;
// 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


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

class Solution429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traversal(0, root);
        return result;
    }

    // 递归
    private List<List<Integer>> result = new ArrayList<>();
    private void traversal(int level, Node node) {
        if (result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        for (Node item : node.children) {
            traversal(level + 1, item);
        }
    }

    // for循环遍历 bfs
    public List<List<Integer>> bfs(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
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
