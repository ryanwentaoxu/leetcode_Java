/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            } 
        };
        Arrays.sort(intervals, c); 

        int ans = 1;
        List<List<int[]>> l = new ArrayList();
        l.add(new ArrayList<>());
        l.get(0).add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] t = intervals[i];
            int start = t[0];
            int end = t[1];
            boolean isInsert = false;
            for (int j = 0; j < l.size(); j++) {
                if (start >= l.get(j).get(l.get(j).size() - 1)[1]) {
                    isInsert = true;
                    l.get(j).add(t);
                    break;
                }
            }
            if (isInsert == false) {
                l.add(new ArrayList<>());
                l.get(l.size() - 1).add(t);
            }
        }
        return l.size();
    }
}
// @lc code=end

