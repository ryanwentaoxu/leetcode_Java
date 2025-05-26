/*
 * @lc app=leetcode id=2492 lang=java
 *
 * [2492] Minimum Score of a Path Between Two Cities
 */

// @lc code=start
class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union_set(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if (xset == yset) return;

        if (rank[xset] > rank[yset]) {
            int tmp = xset;
            xset = yset;
            yset = tmp;
        }
        parent[xset] = yset;
        rank[yset] += rank[xset];
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        UnionFind dsu = new UnionFind(n + 1);
        int answer = Integer.MAX_VALUE;
        
        for (int[] road : roads) {
            dsu.union_set(road[0], road[1]);
        }

        for (int[] road : roads) {
            if (dsu.find(1) == dsu.find(road[0])) {
                answer = Math.min(answer, road[2]);
            }
        }
        return answer;
    }
}
// @lc code=end

