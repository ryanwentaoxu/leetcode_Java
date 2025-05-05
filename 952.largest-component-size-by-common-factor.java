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

import java.util.Map;

class DSU {
    int[] parent;
    int[] num;
    int size;

    public DSU(int size) {
        this.size = size;
        this.parent = new int[this.size + 1];
        this.num = new int[this.size + 1];
        for (int i = 1; i <= this.size; i++) {
            this.parent[i] = i;
            this.num[i] = 1;
        }
    }

    public int findParent(int node) {
        int p = parent[node];
        if (node != p) {
            parent[node] = findParent(p);
        }
        return parent[node];
    }

    public int union(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (p1 == p2) return p1;
        else {
            int n1 = this.num[p1];
            int n2 = this.num[p2];
            if (n1 > n2) {
                int p = p1;
                p1 = p2;
                p2 = p;
            }
            parent[p1] = p2;
            num[p2] += num[p1];
            return findParent(p2);
        }
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
                    dsu.union(i, num);
                    dsu.union(num / i, num);
                }
            }
        }
        // group id

        Map<Integer, Integer> map = new HashMap();

        // get the answer;
        int ans = 0;
        for (int num : nums) {
            int p = dsu.findParent(num);
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p) > ans) ans += 1;
        }
        return ans;
    }
}
// @lc code=end

