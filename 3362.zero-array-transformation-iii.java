/*
 * @lc app=leetcode id=3362 lang=java
 *
 * [3362] Zero Array Transformation III
 */

// @lc code=start
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int n = nums.length;
        int[] delta = new int[n + 1];
        int operations = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < n; i++) {
            operations += delta[i];

            while (j < queries.length && queries[j][0] == i) {
                pq.offer(queries[j][1]);
                j += 1; 
            }

            while (!pq.isEmpty() && pq.peek() >= i && operations < nums[i]) {
                int end = pq.poll();
                operations += 1;
                delta[end + 1] -= 1;
            }

            if (operations < nums[i]) return -1;
        }
        
        return pq.size();
    }
}
// @lc code=end

