/*
 * @lc app=leetcode id=2492 lang=java
 *
 * [2492] Minimum Score of a Path Between Two Cities
 */

// @lc code=start
class DSU {
    int s;
    int[] parent;
    int[] size;

    public DSU(int s) {
        this.s = s;
        parent = new int[s + 1];
        size = new int[s + 1];
        for (int i = 1; i <= s; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        int px = parent[x];
        if (x != px) {
            parent[x] = find(px);
        }
        return parent[x];
    }

    public int union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return px;

        if (size[px] > size[py]) {
            int tmp = px;
            px = py;
            py = tmp;
        }

        parent[px] = py;
        size[py] += size[px];
        return py;
    }
}


class Solution {
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n);
        for (int[] road : roads) {
            dsu.union(road[0], road[1]);
        }
        int ans = Integer.MAX_VALUE;

        for (int[] road : roads) {
            if (dsu.find(road[0]) == dsu.find(1)) {
                ans = Math.min(ans, road[2]);
            } 
        }
        return ans;
    }
}
// @lc code=end

