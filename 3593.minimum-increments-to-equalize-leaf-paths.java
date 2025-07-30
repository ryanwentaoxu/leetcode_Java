/*
 * @lc app=leetcode id=3593 lang=java
 *
 * [3593] Minimum Increments to Equalize Leaf Paths
 */

// @lc code=start
class Solution {
    int ans;
    int[] cost;
    public int minIncrease(int n, int[][] edges, int[] cost) {
        Map<Integer, List<Integer>> adj = new HashMap();
        Map<Integer, Long> map = new HashMap();
        ans = 0;
        this.cost = cost;
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] edge : edges) {
            adj.get(Math.min(edge[0], edge[1])).add(Math.max(edge[0], edge[1]));
        }
        helper(0, adj, map);
        return ans;
    }

    public long helper(int node, Map<Integer, List<Integer>> adj, Map<Integer, Long> map) {
        if (map.containsKey(node)) return map.get(node);
        if (adj.get(node).size() == 0) return cost[node];
        long max = 0;
        int count = 0;
        for (int n : adj.get(node)) {
            long sub = helper(n, adj, map);
            if (sub > max) {
                max = sub;
                count = 1;
            } else if (sub == max) {
                count += 1;
            }
        }
        ans += adj.get(node).size() - count;
        map.put(node, max + cost[node]);
        return max + cost[node];
    }
}
// @lc code=end

