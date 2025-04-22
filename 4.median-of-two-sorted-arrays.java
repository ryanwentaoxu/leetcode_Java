/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        if ((lenA + lenB) % 2 == 1) {
            return helper(nums1, nums2, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1);
        } else {
            int A = helper(nums1, nums2, (lenA + lenB) / 2 - 1, 0, lenA - 1, 0, lenB - 1);
            int B = helper(nums1, nums2, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1);
            return (A + B) / 2.0;
        }
    }

    public int helper(int[] A, int[] B, int k, int startA, int endA, int startB, int endB) {
        if (startA > endA) return B[k - startA];
        if (startB > endB) return A[k - startB];
        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;
        if ((midA + midB) >= k) {
            if (A[midA] > B[midB]) {
                return helper(A, B, k, startA, midA - 1, startB, endB);
            } else {
                return helper(A, B, k, startA, endA, startB, endB - 1);
            }
        } else {
            if (A[midA] > B[midB]) {
                return helper(A, B, k, startA, endA, midB + 1, endB);
            } else {
                return helper(A, B, k, midA + 1, endA, startB, endB);
            }
        }
    }
}
// @lc code=end

