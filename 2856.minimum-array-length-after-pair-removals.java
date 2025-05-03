/*
 * @lc app=leetcode id=2856 lang=java
 *
 * [2856] Minimum Array Length After Pair Removals
 */

// @lc code=start
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) pq.add(entry.getValue());
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            num1 --;
            num2 --;
            if (num1 > 0) pq.offer(num1);
            if (num2 > 0) pq.offer(num2);
        }
        int ans = 0;
        while (pq.size() > 0) ans += pq.poll();
        return ans;
    }
}
// @lc code=end

