/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int ans = 0;
        int startPointer = 0;
        int endPointer = 0;
        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                ans -= 1;
                endPointer += 1;
            }
            ans += 1;
            startPointer += 1;
        }
        return ans;
    }
}
// @lc code=end

