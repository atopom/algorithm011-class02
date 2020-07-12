package com.atopom.leetcode.editor.cn;
// 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
// 式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
// 反序列化为原始的树结构。
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
// 序列化为 "[1,2,3,null,null,4,5]"
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
// 个问题。
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
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
class Codec297 {

    /**
     * @Description: 递归，前序遍历
     * @Param: [root]
     * @Return: java.lang.String
     * @Author: wangyanan
     * @Date: 08:46
     **/
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        serializeHelper(root, sb);
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    /**
     * @Description: 递归，
     * @Param: [data]
     * @Return: com.atopom.leetcode.editor.cn.Codec297.TreeNode
     * @Author: wangyanan
     * @Date: 08:46
     **/
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        data = data.replace("[", "").replace("]", "");
        String[] nodes = data.split(",");
        if (nodes.length <= 0 || "null".equals(nodes[0])) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String node = queue.poll();
        if ("null".equalsIgnoreCase(node)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(node));
        treeNode.left = deserializeHelper(queue);
        treeNode.right = deserializeHelper(queue);
        return treeNode;
    }

    /**
     * @Description: 非递归
     * @Param: [root]
     * @Return: java.lang.String
     * @Author: wangyanan
     * @Date: 08:15
     **/
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            sb.append(curr.val).append(",");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * @Description: 非递归
     * @Param: [root]
     * @Return: java.lang.String
     * @Author: wangyanan
     * @Date: 08:15
     **/
    public TreeNode deserialize2(String data) {
        if (data == null || data.isEmpty()) return null;
        data = data.replace("[", "").replace("]", "");
        String[] nodes = data.split(",");
        if (nodes.length <= 0 || "null".equals(nodes[0])) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length; i = i + 2) {
            TreeNode curr = queue.poll();
            String left = nodes[i];
            String right = nodes[i + 1];
            if (!"null".equals(left)) {
                curr.left = new TreeNode(Integer.valueOf(left));
                queue.add(curr.left);
            }
            if (!"null".equals(right)) {
                curr.right = new TreeNode(Integer.valueOf(right));
                queue.add(curr.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        root.right.left = node4;
        root.right.right = node5;
        Codec297 codec297 = new Codec297();
        String serialize = codec297.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec297.deserialize(serialize);
        String serialize2 = codec297.serialize(deserialize);
        System.out.println(serialize2);
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
