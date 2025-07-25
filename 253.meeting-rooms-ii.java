/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> start = new ArrayList();
        List<Integer> end = new ArrayList();
        for (int[] interval : intervals) {
            start.add(interval[0]);
            end.add(interval[1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int n = intervals.length;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (start.get(i) >= end.get(j)) {
                ans -= 1;
                j += 1;
            }
            ans += 1;
        }
        return ans;
    }
}
// @lc code=end

