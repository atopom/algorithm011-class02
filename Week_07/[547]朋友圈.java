package com.atopom.kata.leetcode.editor.cn;

// 朋友圈
class Solution547 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                result++;
            }
        }
        return result;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
