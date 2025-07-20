/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int i = s.length() - 2;
        char[] ss = s.toCharArray();
        while (i >= 0 && ss[i] - '0' >= ss[i + 1] - '0') {
            i = i - 1;
        }

        if (i >= 0) {
            try {
                int j = s.length() - 1;
                while (ss[j] - '0' <= ss[i] - '0') {
                    j = j - 1;
                }
                // System.out.println(j);
                swap(ss, i, j);
                reverse(ss, i + 1);
                
                return Integer.valueOf(String.valueOf(ss));
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    public void swap(char[] nums, int index1, int index2) {
        char tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public void reverse(char[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }
}
// @lc code=end

