/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> indegrees = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, new HashSet<>());
        } 
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : indegrees.entrySet()) {
            if (entry.getValue().size() == 0) {
                q.add(entry.getKey());
                visited.add(entry.getKey());
            }
        }
        int[] ans = new int[numCourses];
        int count = 0;
        while (q.size() != 0) {
            int c = q.poll();
            ans[count++] = c;
            
            for (int i = 0; i < numCourses; i++) {
                indegrees.get(i).remove(c);
                if (indegrees.get(i).size() == 0 && visited.contains(i) == false) {
                    q.add(i);
                    visited.add(i);
                }
            }
        }
        if (count == numCourses) return ans;
        return new int[0];

    }
}
// @lc code=end

