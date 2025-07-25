/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n : nums) set.add(n);
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int tmp = 1;
                int tnum = num;
                while (set.contains(tnum + 1)) {
                    tmp += 1;
                    tnum += 1;
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
// @lc code=end

