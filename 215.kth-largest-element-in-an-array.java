/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start

import java.util.List;
import java.util.Random;

class Solution {
    Random rnd;
    public int findKthLargest(int[] nums, int k) {
        List<Integer> l = new ArrayList();
        for (int n : nums) l.add(n);
        rnd = new Random();
        return quickSelect(l, nums.length - k + 1);
    }

    public int quickSelect(List<Integer> list, int k) {
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        List<Integer> mid = new ArrayList();
        int pivotIndex = rnd.nextInt(list.size());
        int pivot = list.get(pivotIndex);
        for (int n : list) {
            if (n < pivot) {
                left.add(n);
            } else if (n == pivot) {
                mid.add(n);
            } else {
                right.add(n);
            }
        }

        if (k <= left.size()) return quickSelect(left, k);
        if (k <= (left.size() + mid.size())) return pivot;
        return quickSelect(right, k - (left.size() + mid.size()));
    }
}
// @lc code=end

