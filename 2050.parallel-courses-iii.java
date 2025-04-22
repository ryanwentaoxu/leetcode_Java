/*
 * @lc app=leetcode id=2050 lang=java
 *
 * [2050] Parallel Courses III
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> neighs = new HashMap();
        Map<Integer, Integer> map = new HashMap();
        for (int i = 1; i <= n; i++) {
            neighs.put(i, new ArrayList<>());
        }

        for (int i = 0; i < relations.length; i++) {
            neighs.get(relations[i][0]).add(relations[i][1]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dfs(i, neighs, time, map));
        }
        return ans;
    }

    public int dfs(int node, Map<Integer, List<Integer>> neighs, int[] time, Map<Integer, Integer> map) {
        if (neighs.get(node).size() == 0) return time[node - 1];
        if (map.containsKey(node) == true) return map.get(node);
        int ans = Integer.MIN_VALUE;
        for (int n : neighs.get(node)) {
            ans = Math.max(ans, dfs(n, neighs, time, map) + time[node - 1]);
        }
        map.put(node, ans);
        return map.get(node);
    }
}
// @lc code=end

