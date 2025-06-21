/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        Set<Pair<Integer, Integer>> visited = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (visited.contains(new Pair(i, j))) continue;
                if (board[i][j] == 'X') continue;
                if (helper(i, j, board, visited)) {
                    // System.out.println("!!!");
                    // System.out.println(i);
                    // System.out.println(j);
                    color(i, j, board);
                }
            }
        }
    }

    public void color(int x, int y, char[][] board) {
        if (board[x][y] == 'X') return;
        board[x][y] = 'X';
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            color(nx, ny, board);
        }
    }

    public boolean helper(int x, int y, char[][] board, Set<Pair<Integer, Integer>> visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (visited.contains(new Pair(x, y))) return true;
        visited.add(new Pair(x, y));
        if (board[x][y] == 'X') return true;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        boolean ret = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            boolean result = helper(nx, ny, board, visited);
            ret = ret && result;
        }
        
        return ret;
    }
}
// @lc code=end

