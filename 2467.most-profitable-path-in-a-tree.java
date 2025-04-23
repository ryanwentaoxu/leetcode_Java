/*
 * @lc app=leetcode id=2467 lang=java
 *
 * [2467] Most Profitable Path in a Tree
 */

// @lc code=start
class Solution {
    int n;
    List<List<Integer>> tree;
    int[] distanceFromBob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        tree = new ArrayList();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        distanceFromBob = new int[n];

        return findPaths(0, 0, 0, bob, amount);
    }
    
    public int findPaths(int sourceNode, int parentNode, int time, int bob, int[] amount) {
        int maxChild = Integer.MIN_VALUE;
        int maxIncome = 0;
        distanceFromBob[sourceNode] = sourceNode == bob ? 0 : n;
        
        for (int adj : tree.get(sourceNode)) {
            if (adj != parentNode) {
                maxChild = Math.max(maxChild, findPaths(adj, sourceNode, time + 1, bob, amount));
                distanceFromBob[sourceNode] = Math.min(distanceFromBob[sourceNode], distanceFromBob[adj] + 1);
            }
        }

        if (distanceFromBob[sourceNode] > time) {
            maxIncome += amount[sourceNode];
        } else if (distanceFromBob[sourceNode] == time) {
            maxIncome += amount[sourceNode] / 2;
        }
        return maxChild == Integer.MIN_VALUE ? maxIncome : maxIncome + maxChild;
    }
}
// @lc code=end

