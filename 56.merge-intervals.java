/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, c);
        List<int[]> l = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                l.add(intervals[i]);
            } else {
                if (intervals[i][0] > l.get(l.size() - 1)[1]) l.add(intervals[i]);
                else {
                    int[] toAdd = new int[]{l.get(l.size() - 1)[0], Math.max(intervals[i][1], l.get(l.size() - 1)[1])};
                    l.set(l.size() - 1, toAdd);
                }
            }
        }
        int[][] ans = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}
// @lc code=end

