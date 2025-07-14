/*
 * @lc app=leetcode id=3440 lang=java
 *
 * [3440] Reschedule Meetings for Maximum Free Time II
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] q = new boolean[n];
        Arrays.fill(q, false);
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < n; i++) {
            if (t1 >= endTime[i] - startTime[i]) q[i] = true;
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            if (t2 >= endTime[n - i - 1] - startTime[n - i - 1]) q[n - i - 1] = true;
            t2 = Math.max(t2, (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int current = endTime[i] - startTime[i];
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            if (q[i]) {
                ans = Math.max(ans, right - left);
            } else {
                ans = Math.max(ans, right - left - current);
            }
        }
        return ans;
    }
}
// @lc code=end

