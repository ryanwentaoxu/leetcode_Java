/*
 * @lc app=leetcode id=2359 lang=java
 *
 * [2359] Find Closest Node to Given Two Nodes
 */

// @lc code=start
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] nums = edges;
        if (node1 == node2) return node1;
        Map<Integer, Integer> m1 = new HashMap();
        m1.put(node1, 0);
        Map<Integer, Integer> m2 = new HashMap();
        m2.put(node2, 0);
        int n1 = node1;
        int n2 = node2;
        int count1 = 1;
        int count2 = 1;


        Set<Integer> visited1 = new HashSet();
        visited1.add(n1);
        Set<Integer> visited2 = new HashSet();
        visited2.add(n2);
        while (nums[n1] != -1) {
            if (visited1.contains(nums[n1])) break;
            visited1.add(nums[n1]);
            m1.put(nums[n1], count1++);
            n1 = nums[n1];
        }
        while (nums[n2] != -1) {
            if (visited2.contains(nums[n2])) break;
            visited2.add(nums[n2]);
            m2.put(nums[n2], count2++);
            n2 = nums[n2];
        }

        int dist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (m1.containsKey(i) && m2.containsKey(i)) {
                if (Math.max(m1.get(i), m2.get(i)) < dist) {
                    dist = Math.max(m1.get(i), m2.get(i));
                    ans = i;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

