/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }
        int ans = 0;
        while (pq.isEmpty() == false) {
            int counter = n + 1;
            int count = 0;
            List<Integer> tmp = new ArrayList<>();
            while (pq.isEmpty() == false && counter > 0) {
                counter -= 1;
                int t = pq.poll();
                if (t > 1) tmp.add(t);
                count += 1;
            }
            for (int t : tmp) {
                pq.offer(t - 1);
            }
            ans += pq.size() == 0 ? count : n + 1;
        }
        return ans;
    }
}
// @lc code=end

