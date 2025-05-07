/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 *
 * https://leetcode.com/problems/sliding-window-median/description/
 *
 * algorithms
 * Hard (38.64%)
 * Likes:    3374
 * Dislikes: 218
 * Total Accepted:    181.1K
 * Total Submissions: 468.8K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * The median is the middle value in an ordered integer list. If the size of
 * the list is even, there is no middle value. So the median is the mean of the
 * two middle values.
 * 
 * 
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * You are given an integer array nums and an integer k. There is a sliding
 * window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 * 
 * Return the median array for each window in the original array. Answers
 * within 10^-5 of the actual value will be accepted.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation: 
 * Window position                Median
 * ---------------                -----
 * [1  3  -1] -3  5  3  6  7        1
 * ⁠1 [3  -1  -3] 5  3  6  7       -1
 * ⁠1  3 [-1  -3  5] 3  6  7       -1
 * ⁠1  3  -1 [-3  5  3] 6  7        3
 * ⁠1  3  -1  -3 [5  3  6] 7        5
 * ⁠1  3  -1  -3  5 [3  6  7]       6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start

import java.util.Comparator;
import java.util.TreeSet;

class Solution {

    public void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (right.size() < left.size()) {
            right.add(left.pollFirst());
        }
    }

    public Double getNext(int k, TreeSet<Integer> left, TreeSet<Integer> right, int[] nums) {
        if (k % 2 == 1) {
            Double ret = Double.valueOf(nums[(int)(right.first())]);
            return ret;
        }
        else {
            Double l =  Double.valueOf(nums[(int)(left.first())]);
            Double r =  Double.valueOf(nums[(int)(right.first())]);
            return (l + r) / 2.0;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o1] == nums[o2]) return o1 - o2;
                return nums[o1] - nums[o2];
            }
        };
        
        int n = nums.length;
        TreeSet<Integer> left = new TreeSet(c.reversed());
        TreeSet<Integer> right = new TreeSet(c);
        
        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance(left, right);
        double[] ans = new double[n - k + 1];
        int index = 0;
        ans[index++] = getNext(k, left, right, nums);
        
        for (int i = k; i < n; i++) {
            left.remove(i - k);
            right.remove(i - k);
            left.add(i);
            balance(left, right);
            ans[index++] = getNext(k, left, right, nums);
        }
        return ans;

    }
}
// @lc code=end

