/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(events, c);
        PriorityQueue<Integer> pq = new PriorityQueue();
        int i = 0;
        int ans = 0;
        for (int d = 1; d <= 100000; d++) {
            while (i < events.length && events[i][0] == d) {
                pq.offer(events[i++][1]);
            }
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

