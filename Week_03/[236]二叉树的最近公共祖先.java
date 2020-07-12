package com.atopom.leetcode.editor.cn;
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出: 3
// 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出: 5
// 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {

    private HashMap<Integer, TreeNode> hashParent = new HashMap<>();
    private Set<Integer> visitedRoot = new HashSet<>();
    /**
     * @Description: 哈希
     * @Param: [root, p, q]
     * @Return: com.atopom.leetcode.editor.cn.Solution236.TreeNode
     * @Author: wangyanan
     * @Date: 5:15 下午
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visitedRoot.add(p.val);
            p = hashParent.get(p.val);
        }
        while (q != null) {
            if (visitedRoot.contains(q.val)) {
                return q;
            }
            q = hashParent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            hashParent.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            hashParent.put(node.right.val, node);
            dfs(node.right);
        }
    }

    private TreeNode result;
    /**
     * @Description: 递归
     * @Param: [root, p, q]
     * @Return: com.atopom.leetcode.editor.cn.Solution236.TreeNode
     * @Author: wangyanan
     * @Date: 5:14 下午
     **/
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        if ((lson && rson) || ((lson || rson) && (node.val == p.val || node.val == q.val))) {
            result = node;
        }
        return lson || rson || node.val == p.val || node.val == q.val;
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
