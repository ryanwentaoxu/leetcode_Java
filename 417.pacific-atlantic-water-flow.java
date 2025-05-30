/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    int[] xd = new int[] {-1, 1, 0, 0};
    int[] yd = new int[] {0, 0, -1, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pr = new boolean[rows][cols];
        boolean[][] ar = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pr, heights);
            dfs(i, cols - 1, ar, heights);
        }

        for (int i = 0; i < cols; i++) {
            dfs(0, i, pr, heights);
            dfs(rows - 1, i, ar, heights);
        }

        List<List<Integer>> ret = new ArrayList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pr[i][j] && ar[i][j]) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(i);
                    tmp.add(j);
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

    public void dfs(int x, int y, boolean[][] reachable, int[][] heights) {
        reachable[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + xd[i];
            int ny = y + yd[i];
            if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length) {
                continue;
            }
            if (reachable[nx][ny]) {
                continue;
            }
            if (heights[x][y] > heights[nx][ny]) {
                continue;
            }
            dfs(nx, ny, reachable, heights);
        }
    }
}
// @lc code=end

