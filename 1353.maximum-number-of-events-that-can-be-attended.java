/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue();
        int ans = 0;
        int maxDay = 100000;
        int index = 0;
        for (int i = 1; i <= maxDay; i++) {
            while (index < events.length && events[index][0] <= i) {
                pq.offer(events[index][1]);
                index += 1;
            }

            while (!pq.isEmpty() && pq.peek() < i) {
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

