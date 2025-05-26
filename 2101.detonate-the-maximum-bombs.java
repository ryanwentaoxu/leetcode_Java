/*
 * @lc app=leetcode id=2101 lang=java
 *
 * [2101] Detonate the Maximum Bombs
 */

// @lc code=start
class Solution {
    public boolean withIn(int[] b1, int[] b2) {
        double distance = ((double)b1[0] - (double)b2[0]) * ((double)b1[0] - (double)b2[0]) + ((double)b1[1] - (double)b2[1]) * ((double)b1[1] - (double)b2[1]);
        double range = (double)(b1[2]) * (double)(b1[2]);
        return range >= distance;
    }

    Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> neighs;
    Map<Pair<Integer, Integer>, Integer> freq;

    public int maximumDetonation(int[][] bombs) {
        neighs = new HashMap();
        freq = new HashMap();
        for (int[] b : bombs) {
            neighs.put(new Pair(b[0], b[1]), new ArrayList());
            freq.put(new Pair(b[0], b[1]), freq.getOrDefault(new Pair(b[0], b[1]), 0) + 1);
        }
        for (int[] b1 : bombs) {
            for (int[] b2 : bombs) {
                boolean isN = withIn(b1, b2);
                if (isN) {
                    neighs.get(new Pair(b1[0], b1[1])).add(new Pair(b2[0], b2[1]));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int[] b : bombs) {
            ans = Math.max(ans, DFS(b, new HashSet<Pair<Integer, Integer>>()));
        }
        return ans;
    }

    public int DFS(int[] bomb, Set<Pair<Integer, Integer>> visited) {
        if (visited.contains(new Pair(bomb[0], bomb[1]))) return 0;
        visited.add(new Pair(bomb[0], bomb[1]));
        int ans = freq.get(new Pair(bomb[0], bomb[1]));
        for (Pair<Integer, Integer> p : neighs.get(new Pair(bomb[0], bomb[1]))) {
            ans += DFS(new int[]{p.getKey(), p.getValue()}, visited); 
        }
        return ans;
    }
}
// @lc code=end

