class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] steps = new int[grid.length][grid[0].length];
        for (int[] s : steps) {
            Arrays.fill(s, 0);
        }
        int round = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList();
                    q.offer(new int[]{i, j});
                    int total_steps = 0;

                    ans = Integer.MAX_VALUE;


                    while (q.isEmpty() == false) {
                        total_steps += 1;
                        for (int level = q.size(); level > 0; level--) {
                            int[] current = q.poll();
                            for (int[] d : directions) {
                                int nx = current[0] + d[0];
                                int ny = current[1] + d[1];

                                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[i].length && grid[nx][ny] == round) {
                                    steps[nx][ny] += total_steps;
                                    grid[nx][ny] -= 1;
                                    ans = Math.min(ans, steps[nx][ny]);
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    round -= 1;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}