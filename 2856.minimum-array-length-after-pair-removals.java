/*
 * @lc app=leetcode id=2856 lang=java
 *
 * [2856] Minimum Array Length After Pair Removals
 */

// @lc code=start
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> freq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.offer(entry.getValue());
        }
        int ans = 0;
        while (!freq.isEmpty() && freq.size() >= 2) {
            int num1 = freq.poll();
            int num2 = freq.poll();
            if (num1 > 1) freq.offer(num1 - 1);
            if (num2 > 1) freq.offer(num2 - 1);
        }
        while (!freq.isEmpty()) ans += freq.poll();
        return ans;
    }
}
// @lc code=end

