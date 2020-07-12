package com.atopom.leetcode.editor.cn;
// 根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
// 你可以假设树中没有重复的元素。
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树： 
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Related Topics 树 深度优先搜索 数组 
// 👍 559 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution105 {

    private HashMap<Integer, Integer> rootMap;

    /**
     * @Description: 递归
     * @Param: [preorder, inorder]
     * @Return: com.atopom.leetcode.editor.cn.Solution105.TreeNode
     * @Author: wangyanan
     * @Date: 15:35
     **/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        // 递归终结条件
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int rootVal = preorder[preorderLeft];
        // 根据根节点获取中序遍历中根节点的索引
        int rootIndex = rootMap.get(rootVal);
        TreeNode treeNode = new TreeNode(rootVal);
        // 获取左子树的节点数
        int leftNodeSize = rootIndex - inorderLeft;
        // 中序遍历，根节点的左边是左子树，右边是右子树
        treeNode.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + leftNodeSize, inorderLeft, rootIndex - 1);
        treeNode.right = build(preorder, inorder, preorderLeft + leftNodeSize + 1, preorderRight, rootIndex + 1, inorderRight);
        return treeNode;
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
