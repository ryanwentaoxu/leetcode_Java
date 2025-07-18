/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int n = start.length;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] >= end[endIndex]) {
                ans -= 1;
                endIndex++;
            }
            ans += 1;
        }
        return ans;
    }
}
// @lc code=end

