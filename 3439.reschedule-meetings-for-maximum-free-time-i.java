/*
 * @lc app=leetcode id=3439 lang=java
 *
 * [3439] Reschedule Meetings for Maximum Free Time I
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int ret = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += endTime[i] - startTime[i];
            int right = (i == n - 1 ? eventTime : startTime[i + 1]);
            int left = (i > k - 1 ? endTime[i - k] : 0);
            ret = Math.max(ret, right - left - t);
            if (i >= k - 1) t -= endTime[i - k + 1] - startTime[i - k + 1]; 
        }
        return ret;
    }
}
// @lc code=end

