/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] cells = new int[N][N];
        for (int[] r : rows) Arrays.fill(r, -1);
        for (int[] c : cols) Arrays.fill(c, -1);
        for (int[] c : cells) Arrays.fill(c, -1);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int pos = (int)(board[i][j] - '0');
                pos -= 1;
                int rowIndex = i;
                int colIndex = j;
                int cellIndex = (i / 3) * 3 + j / 3;
                if (rows[rowIndex][pos] != -1) return false;
                if (cols[colIndex][pos] != -1) return false;
                if (cells[cellIndex][pos] != -1) return false;
                rows[rowIndex][pos] = 1;
                cols[colIndex][pos] = 1;
                cells[cellIndex][pos] = 1;
            }
        }
        return true;
    }
}