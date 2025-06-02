/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<List<int[]>> rooms = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (rooms.size() == 0) {
                rooms.add(new ArrayList());
                rooms.get(0).add(current);
            } else {
                boolean added = false;
                for (int j = 0; j < rooms.size(); j++) {
                    int[] prev = rooms.get(j).get(rooms.get(j).size() - 1);
                    if (prev[1] <= current[0]) {
                        added = true;
                        rooms.get(j).add(current);
                        break;
                    }
                }
                if (!added) {
                    rooms.add(new ArrayList());
                    rooms.get(rooms.size() - 1).add(current);   
                }
            }
        }
        return rooms.size();
    }
}
// @lc code=end

