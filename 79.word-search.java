/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    char[][] board;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int index = 0;
                    boolean result = backtrack(i, j, index, word);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, int index, String word) {
        if (index == word.length()) return true;
        if (word.charAt(index) != board[row][col]) return false;
        if (index == word.length() - 1) return true;
        char prev = board[row][col];
        board[row][col] = '-';
        boolean ret = false;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
            boolean result = backtrack(nx, ny, index + 1, word);
            if (result) {
                ret = ret || result;
                break;
            }
        }
        board[row][col] = prev;
        return ret;
    }
}
// @lc code=end

