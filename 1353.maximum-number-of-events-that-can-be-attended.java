/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(events, c);
        int index = 0;
        int ans = 0; 
        for (int d = 1; d <= 100000; d++) {
            while (index < events.length && events[index][0] == d) {
                pq.offer(events[index][1]);
                index++;
            }
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

