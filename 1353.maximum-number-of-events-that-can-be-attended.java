/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(events, c);
        int i = 0;
        for (int d = 1; d <= 100000; d++) {
            while (i < events.length && events[i][0] == d) {
                pq.add(events[i][1]);
                i++;
            }
            while (pq.isEmpty() != true && pq.peek() < d) {
                pq.poll();
            }
            if (pq.isEmpty() == false) {
                pq.poll();
                ans += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

