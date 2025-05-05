/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, c);
        List<int[]> ret = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) ret.add(intervals[i]);
            else {
                if (intervals[i][0] <= ret.get(ret.size() - 1)[1]) {
                    int start = ret.get(ret.size() - 1)[0];
                    int end = Math.max(intervals[i][1], ret.get(ret.size() - 1)[1]);
                    ret.set(ret.size() - 1, new int[]{start, end});
                } else {
                    ret.add(intervals[i]);
                }
            }
        }
        int[][] ans = new int[ret.size()][2];
        int count = 0;
        for (int[] t : ret) {
            ans[count++] = t;
        }
        return ans;
    }
}
// @lc code=end

