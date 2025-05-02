/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start

class Solution {
    Set<Pair<Integer, Integer>> visited;
    int ans;
    int[][] grid;
    public int populate(int i, int j) {
        if (visited.contains(new Pair(i, j)) == true) return 0;
        if (this.grid[i][j] != 1) return 0;
        visited.add(new Pair(i, j));
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ret = 1;
        for (int[] d : directions) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            ret += populate(nx, ny);
        }
        return ret;
    }
    public int maxAreaOfIsland(int[][] grid) {
        ans = 0;
        this.grid = grid;
        visited = new HashSet();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited.contains(new Pair(i, j)) == false) {
                    ans = Math.max(ans, populate(i, j));
                }
            }
        }
        return ans;
    }
}
// @lc code=end

