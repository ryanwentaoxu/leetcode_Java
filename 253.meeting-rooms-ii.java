/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        List<Integer> start = new ArrayList();
        List<Integer> end = new ArrayList();
        for (int[] i : intervals) {
            start.add(i[0]);
            end.add(i[1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        
        int ans = 0;
        int startPointer = 0;
        int endPointer = 0;
        while (startPointer < intervals.length) {
            if (start.get(startPointer) >= end.get(endPointer)) {
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

