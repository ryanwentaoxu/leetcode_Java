/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int count = 0;
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int current = trips[i][1];
            int dest = trips[i][2];
            map.put(dest, map.getOrDefault(dest, 0) + num);
            count += num;
            count -= map.getOrDefault(current, 0);
            Set<Integer> visited = new HashSet<Integer>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() < current) {
                    visited.add(entry.getKey());
                    count -= entry.getValue();
                }
            }
            for (int v : visited) map.remove(v);
            map.remove(current);
            
            if (count > capacity) return false;
        }
        return true;
    }
}
// @lc code=end

