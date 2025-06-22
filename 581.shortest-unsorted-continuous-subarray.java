/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        boolean check = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                check = false;
                break;
            }
        }
        if (check) return 0;
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList();
        // int involvedMIn = Integer.MAX_VALUE;
        // int involvedMax = Integer.MIN_VALUE;
        int lastToAdd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (stack.size() == 0 || nums[stack.peek()] <= nums[i]) {
                stack.push(i);
            } else {
                // edge case
                // 1, 2, 5, 4, 6, 4
                // 1, 2, 3
                int popedMaxIndex = -1;
                int maxVal = Integer.MIN_VALUE;
                while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                    int toAdd = stack.pop();
                    if (nums[toAdd] >= maxVal) {
                        maxVal = nums[toAdd];
                        popedMaxIndex = toAdd;
                    }
                    list.add(toAdd);
                }
                list.add(i);
                stack.push(popedMaxIndex);
            }
        }
        if (lastToAdd != -1) list.add(lastToAdd);
        
        int minindex = Integer.MAX_VALUE;
        int maxindex = Integer.MIN_VALUE;

        for (int num : list) {
            minindex = Math.min(minindex, num);
            maxindex = Math.max(maxindex, num);
        }
        return maxindex - minindex + 1;
    }
}
// @lc code=end

