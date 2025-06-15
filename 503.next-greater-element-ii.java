/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }
            ret[i % n] = stack.size() == 0 ? -1 : nums[stack.peek()];
            stack.push(i % n); 
        }
        return ret;
    }
}
// @lc code=end

