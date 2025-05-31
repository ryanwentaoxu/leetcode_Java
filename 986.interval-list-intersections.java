/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lBound = Math.min(firstList[i][1], secondList[j][1]);
            int rBound = Math.max(firstList[i][0], secondList[j][0]);
            if (rBound <= lBound) ans.add(new int[]{rBound, lBound});
            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        int[][] ret = new int[ans.size()][2];
        for (int m = 0; m < ans.size(); m++) {
            ret[m] = ans.get(m);
        }
        return ret;
    }
}
// @lc code=end

