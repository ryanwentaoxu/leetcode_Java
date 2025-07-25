/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if ((n1 + n2) % 2 == 0) {
            int ans1 = helper(nums1, nums2, n / 2, 0, n1 - 1, 0, n2 - 1);
            int ans2 = helper(nums1, nums2, n / 2 - 1, 0, n1 - 1, 0, n2 - 1);
            return ((double)(ans1 + ans2)) / 2;
        } else {
            int ans = helper(nums1, nums2, n / 2, 0, n1 - 1, 0, n2 - 1);
            return (double)ans;
        }
    }

    public int helper(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2) {
        if (start1 > end1) return nums2[k - start1];
        if (start2 > end2) return nums1[k - start2];
        int mid1 = (start1 + end1) / 2;
        int mid2 = (start2 + end2) / 2;
        if ((mid1 + mid2) >= k) {
            if (nums1[mid1] > nums2[mid2]) {
                return helper(nums1, nums2, k, start1, mid1 - 1, start2, end2);
            } else {
                return helper(nums1, nums2, k, start1, end1, start2, mid2 - 1);
            }
        } else {
            if (nums1[mid1] > nums2[mid2]) {
                return helper(nums1, nums2, k, start1, end1, mid2 + 1, end2);
            } else {
                return helper(nums1, nums2, k, mid1 + 1, end1, start2, end2);
            }
        }
    }
}
// @lc code=end

