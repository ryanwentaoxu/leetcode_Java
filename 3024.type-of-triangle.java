/*
 * @lc app=leetcode id=3024 lang=java
 *
 * [3024] Type of Triangle
 */

// @lc code=start
class Solution {
    public String triangleType(int[] nums) {
        if (nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2]) {
            if (nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0]) {
                return "scalene";
            }
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
           return "equilateral";
        }

        if (nums[0] == nums[1] && nums[0] + nums[1] > nums[2]) {
            return "isosceles";
        }

        if (nums[2] == nums[1] && nums[2] + nums[1] > nums[0]) {
            return "isosceles";
        }

        if (nums[0] == nums[2] && nums[0] + nums[2] > nums[1]) {
            return "isosceles";
        }

        return "none";
    }
}
// @lc code=end

