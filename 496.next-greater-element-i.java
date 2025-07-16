/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.size() == 0) stack.push(nums2[i]);
            else {
                while (stack.size() > 0) {
                    if (nums2[i] > stack.peek()) {
                        map.put(stack.pop(), nums2[i]);
                    } else {
                        break;
                    }
                }
                stack.push(nums2[i]);
            }
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.getOrDefault(nums1[i], -1);
        }
        return ret;
    }
}
// @lc code=end

