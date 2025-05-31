/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int p : piles) right = Math.max(right, p);
        while (left < right) {
            
            int mid = (left + right) / 2;
            int tmp = 0;

            for (int i = 0; i < piles.length; i++) {
                tmp += Math.ceil((double) piles[i] / mid);
            }    
            if (tmp <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
// @lc code=end

