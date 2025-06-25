/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, c);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
// @lc code=end

