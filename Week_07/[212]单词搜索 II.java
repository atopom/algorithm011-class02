package com.atopom.kata.leetcode.editor.cn;
// 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
// words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
// 你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
// 实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
// 
// Related Topics 字典树 回溯算法 


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();
        if (board.length == 0) return result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs3(board, i, j, trie, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, Trie node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '$' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            if (!result.contains(node.word)) result.add(node.word);
            node.word = null;
        }
        board[i][j] = '$';
        dfs(board, i - 1, j, node, result);
        dfs(board, i + 1, j, node, result);
        dfs(board, i, j - 1, node, result);
        dfs(board, i, j + 1, node, result);
        board[i][j] = c;
    }

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private void dfs2(char[][] board, int i, int j, Trie node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '$' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            if (!result.contains(node.word)) result.add(node.word);
            node.word = null;
        }
        board[i][j] = '$';
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            dfs2(board, x, y, node, result);
        }
        board[i][j] = c;
    }

    private int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private void dfs3(char[][] board, int i, int j, Trie node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '$' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            if (!result.contains(node.word)) result.add(node.word);
            node.word = null;
        }
        board[i][j] = '$';
        for (int k = 0; k < direction.length; k++) {
            int x = direction[k][0] + i, y = direction[k][1] + j;
            dfs3(board, x, y, node, result);
        }
        board[i][j] = c;
    }

    class Trie {
        private String word;
        private Trie[] next;

        public Trie() {
            next = new Trie[26];
            word = null;
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            Trie node = this;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int n = c - 'a';
                if (node.next[n] == null) node.next[n] = new Trie();
                node = node.next[n];
            }
            node.word = word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
