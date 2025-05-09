/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    int[][][] memo;
    int[][] grid;
    int N;
    public int cherryPickup(int[][] grid) {
        this.N = grid.length;
        this.grid = grid;
        this.memo = new int[N][N][N];
        for (int[][] mem : memo) {
            for (int[] me : mem) {
                Arrays.fill(me, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0));
    }
    public int dp(int row1, int col1, int col2) {
        if (row1 >= N || col1 >= N || col2 >= N || row1 + col1 - col2 >= N) {
            return -999999;
        }
        if (grid[row1][col1] == -1 || grid[row1 + col1 - col2][col2] == -1) {
            return -999999;
        }
        if (memo[row1][col1][col2] != Integer.MIN_VALUE) {
            return memo[row1][col1][col2];
        }
        if (row1 == N - 1 && col1 == N - 1) {
            return grid[row1][col1];
        }
        int ret = grid[row1][col1];
        if (col1 != col2) ret += grid[row1 + col1 - col2][col2];
        int ret1 = dp(row1 + 1, col1, col2);
        int ret2 = dp(row1, col1 + 1, col2);
        int ret3 = dp(row1 + 1, col1, col2 + 1);
        int ret4 = dp(row1, col1 + 1, col2 + 1);
        ret += Math.max(Math.max(ret1, ret2), Math.max(ret3, ret4));
        memo[row1][col1][col2] = ret;
        return ret;
    }
}
// @lc code=end

