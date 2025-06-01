/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int ans = 0;
        while (left <= right) {
            if ((people[left] + people[right]) <= limit) {
                ans += 1;
                left += 1;
                right -= 1;
            } else {
                ans += 1;
                right -= 1;
            }
        }
        return ans;
                                                                           
    }
}
// @lc code=end

