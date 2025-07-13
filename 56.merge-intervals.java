/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList();
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, c);
        for (int i = 0; i < intervals.length; i++) {
            if (ret.size() == 0) ret.add(intervals[i]);
            else {
                if (ret.get(ret.size() - 1)[1] < intervals[i][0]) ret.add(intervals[i]);
                else {
                    ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1], intervals[i][1]);
                }
            }
        }
        int[][] ans = new int[ret.size()][2];
        int index = 0;
        for (int[] r : ret) {
            ans[index++] = r;
        }
        return ans;
    }
}
// @lc code=end

