/*
 * @lc app=leetcode id=3537 lang=java
 *
 * [3537] Fill a Special Grid
 */

// @lc code=start
class Solution {
    int val;
    public int[][] specialGrid(int n) {
        val = 0;
        int size = (int)Math.pow(2, n);
        int[][] grid = new int[size][size];
        helper(grid, 0, 0, size);
        return grid;
    }

    public void helper(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            grid[x][y] = val++;
            return;
        }
        int s = length / 2;
        helper(grid, x, y + s, s);
        helper(grid, x + s, y + s, s);
        helper(grid, x + s, y, s);
        helper(grid, x, y, s);
    }

}
// @lc code=end

