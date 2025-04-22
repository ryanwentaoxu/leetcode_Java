/*
 * @lc app=leetcode id=1631 lang=java
 *
 * [1631] Path With Minimum Effort
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            Set<Pair<Integer, Integer>> visited = new HashSet<>();
            boolean ret = gap(mid, 0, 0, heights, visited);
            if (ret == true) {
                if (mid < ans) ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean gap(int distance, int x, int y, int[][] heights, Set<Pair<Integer, Integer>> visited) {
        if (x == heights.length - 1 && y == heights[0].length - 1) return true;
        if (visited.contains(new Pair(x, y)) == true) return false;
        int[] xx = {-1, 1, 0, 0};
        int[] yy = {0, 0, -1, 1};
        visited.add(new Pair(x, y));
        
        for (int i = 0; i < 4; i++) {
            int nx = x + xx[i];
            int ny = y + yy[i];
            if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length) continue;
            if (Math.abs(heights[nx][ny] - heights[x][y]) <= distance) {
                boolean ret = gap(distance, nx, ny, heights, visited);
                if (ret == true) return true;
            }
        }
        return false;
    }
}
// @lc code=end

