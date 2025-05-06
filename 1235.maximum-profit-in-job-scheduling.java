/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList();
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Collections.sort(jobs, c);
        return helper(jobs);
    }

    public int helper(List<int[]> jobs) {
        Comparator<Pair<Integer, Integer>> c = new Comparator<>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        };
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(c);
        int ans = 0;
        int prevProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            int startTime = jobs.get(i)[0];
            int endTime = jobs.get(i)[1];
            int profit = jobs.get(i)[2];
            
            // int prevProfit = 0;
            while (pq.size() > 0 && pq.peek().getKey() <= startTime) {
                Pair<Integer, Integer> current = pq.poll();
                prevProfit = Math.max(prevProfit, current.getValue());
            }

            if (prevProfit > ans) ans = prevProfit;
            
            pq.add(new Pair(endTime, profit + prevProfit));
        }
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> t = pq.poll();
            if (t.getValue() >= ans) ans = t.getValue();
        }

        return ans;
    }
}
// @lc code=end

