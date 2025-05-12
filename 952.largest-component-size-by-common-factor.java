/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 *
 * https://leetcode.com/problems/largest-component-size-by-common-factor/description/
 *
 * algorithms
 * Hard (41.05%)
 * Likes:    1678
 * Dislikes: 95
 * Total Accepted:    58.7K
 * Total Submissions: 143.1K
 * Testcase Example:  '[4,6,15,35]'
 *
 * You are given an integer array of unique positive integers nums. Consider
 * the following graph:
 * 
 * 
 * There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
 * There is an undirected edge between nums[i] and nums[j] if nums[i] and
 * nums[j] share a common factor greater than 1.
 * 
 * 
 * Return the size of the largest connected component in the graph.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,6,15,35]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [20,50,9,63]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,3,6,7,4,12,21,39]
 * Output: 8
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^5
 * All the values of nums are unique.
 * 
 * 
 */

// @lc code=start

class DSU {
    int[] parent;
    int[] size;

    public DSU(int s) {
        parent = new int[s + 1];
        size = new int[s + 1];
        for (int i = 1; i <= s; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        int p = parent[node];
        if (p != node) {
            parent[node] = find(p);
        }
        return parent[node];
    }

    public int union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        if (p1 == p2) return p1;
        if (size[p1] > size[p2]) {
            int tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        parent[p1] = p2;
        size[p2] += size[p1];
        return find(p2);
    }
}

class Solution {
    public int largestComponentSize(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        DSU dsu = new DSU(max);

        // connect all possible nums
        
        
        for (int num : nums) {
            for (int i = 2; i <= (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    dsu.union(num, num / i);
                    dsu.union(num, i);
                }
            }
        }
        // group id

        Map<Integer, Integer> map = new HashMap();

        // get the answer;
        int ans = 0;
        for (int num : nums) {
            int p = dsu.find(num);
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p) > ans) ans += 1;
        }
        return ans;
    }
}
// @lc code=end

