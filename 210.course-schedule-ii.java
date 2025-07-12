/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> indegrees = new HashMap();
        Map<Integer, Set<Integer>> outdegrees = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, new HashSet());
            outdegrees.put(i, new HashSet());
        }
        for (int[] p : prerequisites) {
            indegrees.get(p[0]).add(p[1]);
            outdegrees.get(p[1]).add(p[0]);
        }
        
        Deque<Integer> q = new ArrayDeque();
        for (Map.Entry<Integer, Set<Integer>> entry : indegrees.entrySet()) {
            if (entry.getValue().size() == 0) {
                q.addLast(entry.getKey());
            }
        }
        int[] ans = new int[numCourses];
        Set<Integer> visited = new HashSet();
        int index = 0;
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.removeFirst();
                visited.add(current);
                ans[index++] = current;
                Set<Integer> involved = outdegrees.get(current);
                for (int c : involved) {
                    indegrees.get(c).remove(current);
                    if (indegrees.get(c).size() == 0 && !visited.contains(c)) q.addLast(c);
                }
            }
        }
        return index == numCourses ? ans : new int[] {};
    }
}
// @lc code=end

