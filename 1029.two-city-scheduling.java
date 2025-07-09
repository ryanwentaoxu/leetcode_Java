/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o1[1] < o2[0] - o2[1]) return -1;
                if (o1[0] - o1[1] < o2[0] - o2[1]) return 1;
                
                if (o1[0] + o2[1] <= o1[1] + o2[0]) return -1;
                return 1;
            }
        };
        Arrays.sort(costs, c);
        int ans = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            ans += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            ans += costs[i][1];
        }

        return ans;
    }
}
// @lc code=end

