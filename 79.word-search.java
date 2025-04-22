/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    char[][] board;
    int ROWS;
    int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                boolean ret = dfs(i, j, word, 0);
                if (ret == true) return true;
            }
        }
        return false;
    }

    public boolean isValid(int x, int y) {
        if (x < 0 || x >= ROWS || y < 0 || y >= COLS) return false;
        return true;
    }

    public boolean dfs(int i, int j, String word, int index) {
        if (index == word.length() - 1 && word.charAt(index) == board[i][j]) return true;
        if (word.charAt(index) != board[i][j]) return false;
        this.board[i][j] = '*';
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for (int t = 0; t < 4; t++) {
            if (isValid(i + x[t], j + y[t]) == true) {
                boolean next = dfs(i + x[t], j + y[t], word, index + 1);
                if (next == true) return true;
            }
        }
        this.board[i][j] = word.charAt(index);
        return false;
    }
}
// @lc code=end

