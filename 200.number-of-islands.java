/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    int ans;
    int[] x = new int[]{-1, 1, 0, 0};
    int[] y = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        ans = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair(i, j))) {
                    populate(grid, i, j, visited);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public void populate(char[][] grid, int row, int col, Set<Pair<Integer, Integer>> visited) {
        if (grid[row][col] == '0') return;
        if (visited.contains(new Pair(row, col))) return;
        visited.add(new Pair(row, col));
        for (int i = 0; i < 4; i++) {
            int nx = row + x[i];
            int ny = col + y[i];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            populate(grid, nx, ny, visited);
        }
    }
}
// @lc code=end

