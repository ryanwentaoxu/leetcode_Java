/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 1) return 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                left = mid + 1;
                continue;
            }

            if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
                continue;
            }
            
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
                continue;
            } else {
                right = mid - 1;
                continue;
            }
        }
        return left;
        
    }
}
// @lc code=end

