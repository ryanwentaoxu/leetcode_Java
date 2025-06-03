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

    public State(int x, int y, int dist) {
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
        boolean[][] v = new boolean[rows][cols];
        v[0][0] = true;
        State start = new State(0, 0, 0);
        Comparator<State> c = new Comparator<State>(){
            @Override
            public int compare(State s1, State s2) {
                return s1.dist - s2.dist;
            }
        };
        PriorityQueue<State> pq = new PriorityQueue<State>(c);
        pq.offer(start);
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            v[current.x][current.y] = true;
            int dist = current.dist;
            for (int i = 0;i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue;
                if (v[nx][ny]) continue;
                
                int currentDist = Math.max(current.dist, moveTime[nx][ny]) + 1;
                if (currentDist < d[nx][ny]) {
                    State newState = new State(nx, ny, currentDist);
                    pq.add(newState);
                    d[nx][ny] = currentDist;
                }
            }
        }
        return d[rows - 1][cols - 1];
    }
}
// @lc code=end

