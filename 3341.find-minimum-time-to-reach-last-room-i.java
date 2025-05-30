/*
 * @lc app=leetcode id=3341 lang=java
 *
 * [3341] Find Minimum Time to Reach Last Room I
 */

// @lc code=start
class State implements Comparable<State> {
    int x;
    int y;
    int dist;
    State(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(State s2) {
        return this.dist - s2.dist;
    }
}

class Solution {
    int INF = 0x3f3f3f3f;
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        int[][] d = new int[rows][cols];

        for (int[] dd : d) Arrays.fill(dd, INF);
        d[0][0] = 0;
        
        boolean[][] v = new boolean[rows][cols];
        PriorityQueue<State> pq = new PriorityQueue<>();
        State start = new State(0, 0, moveTime[0][0]);
        pq.offer(start);

        int[] x = new int[] {1, -1, 0, 0};
        int[] y = new int[] {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (v[current.x][current.y]) continue;
            v[current.x][current.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + x[i];
                int ny = current.y + y[i];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue;

                int dist = Math.max(d[current.x][current.y], moveTime[nx][ny]) + 1;

                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    pq.offer(new State(nx, ny, dist));
                }
            }
        }
        return d[rows - 1][cols - 1];
    }
}
// @lc code=end

