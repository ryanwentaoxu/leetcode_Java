/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> indegrees = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, new HashSet());
        }
        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            indegrees.get(to).add(from);
        }
        LinkedList<Integer> dq = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet();

        for (Map.Entry<Integer, Set<Integer>> entry : indegrees.entrySet()) {
            if (entry.getValue().size() == 0) {
                dq.addLast(entry.getKey());
            }
        }
        int[] ret = new int[numCourses];
        int index = -1;
        while (dq.size() != 0) {
            int popSize = dq.size();
            for (int i = 0; i < popSize; i++) {
                int current = dq.pollFirst();
                visited.add(current);
                ret[++index] = current;
                for (Map.Entry<Integer, Set<Integer>> entry : indegrees.entrySet()) entry.getValue().remove(current);
            }
            for (Map.Entry<Integer, Set<Integer>> entry : indegrees.entrySet()) {
                if (entry.getValue().size() == 0 && !visited.contains(entry.getKey())) {
                    dq.addLast(entry.getKey());
                }
            }
        }

        return index == numCourses - 1 ? ret : new int[0];
    }
}
// @lc code=end

