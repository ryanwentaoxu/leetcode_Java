/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int k = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (x >= k) {
                k = y;
            } else {
                ans += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

