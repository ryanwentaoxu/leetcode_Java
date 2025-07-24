/*
 * @lc app=leetcode id=3439 lang=java
 *
 * [3439] Reschedule Meetings for Maximum Free Time I
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int t = 0;
        int ans = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            int gap = endTime[i] - startTime[i];
            t += gap;
            int right = (i == n - 1 ? eventTime : startTime[i + 1]);
            // 1, 2, 3
            // 0, 1, 2
            // k = 2
            int left = (i < k ? 0 : endTime[i - k]);
            if (i >= k) {
                t -= (endTime[i - k] - startTime[i - k]);
            }
            ans = Math.max(ans, right - left - t);
        }
        return ans;
    }
}
// @lc code=end

