/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(events, c);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = 1;
        int end = 100000;
        int count = 0;
        int ans = 0;
        for (int day = start; day <= end; day++) {    
            while (count < events.length && events[count][0] == day) {
                pq.add(events[count][1]);
                count += 1;
            }
            while (pq.isEmpty() == false && pq.peek() < day) {
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

