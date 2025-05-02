/*
 * @lc app=leetcode id=2467 lang=java
 *
 * [2467] Most Profitable Path in a Tree
 */

// @lc code=start
class Solution {
    Map<Integer, List<Integer>> neighs;
    Map<Integer, Integer> distToBob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        neighs = new HashMap();
        distToBob = new HashMap();
        distToBob.put(bob, 0);
        for (int i = 0; i < amount.length; i++) neighs.put(i, new ArrayList());
        for (int i = 0; i < edges.length; i++) {
            neighs.get(edges[i][0]).add(edges[i][1]);
            neighs.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = helper(0, 0, 0, bob, amount);
        return ans;
    }

    public int helper(int node, int parent, int time, int bob, int[] amount) {
        int maxChild = Integer.MIN_VALUE;
        int maxProfit = 0;
        int distFromBob = amount.length;
        for (int i = 0; i < neighs.get(node).size(); i++) {
            int n = neighs.get(node).get(i);
            if (n != parent) {
                int nn = helper(n, node, time + 1, bob, amount);
                maxChild = Math.max(maxChild, nn);
                distFromBob = Math.min(distFromBob, distToBob.get(n) + 1);
            }
        }
        if (node != bob) {
            distToBob.put(node, distFromBob);
        }
        if (distToBob.get(node) == time) maxProfit += amount[node] / 2;
        else if (time < distToBob.get(node)) maxProfit += amount[node];
        return maxChild == Integer.MIN_VALUE ? maxProfit : maxProfit + maxChild;
    }
}
// @lc code=end

