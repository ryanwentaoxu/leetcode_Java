/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 */

// @lc code=start
class Solution {
    public int binarySearch(int[] heaters, int house) {
        int left = 0;
        int right = heaters.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (heaters[mid] == house) return 0;

            if (heaters[mid] < house) left += 1;
            else right -= 1;
        }
        if (right == -1) return Math.abs(heaters[0] - house);
        if (left == heaters.length) return Math.abs(heaters[heaters.length - 1] - house);
        return Math.min(Math.abs(heaters[left] - house), Math.abs(heaters[right] - house));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int current = binarySearch(heaters, houses[i]);
            ans = Math.max(ans, binarySearch(heaters, houses[i]));
        } 
        return ans;
    }
}
// @lc code=end

