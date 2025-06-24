/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> ans = new HashSet();
        int i = 0;
        while (i < nums.length) {
            int current = nums[i];
            int index = current - 1;
            // check if exists or not
            if (nums[index] == current && i != index) {
                ans.add(current);
            }
            if (nums[index] != nums[i]) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            } else {
                i = i + 1;
            }
        }
        return new ArrayList(ans);
    }
}
// @lc code=end

