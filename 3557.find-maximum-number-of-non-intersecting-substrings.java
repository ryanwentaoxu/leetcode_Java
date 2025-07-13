/*
 * @lc app=leetcode id=3557 lang=java
 *
 * [3557] Find Maximum Number of Non Intersecting Substrings
 */

// @lc code=start
class Solution {
    public int maxSubstrings(String word) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!map.containsKey(current)) map.put(current, i);
            else if (i - map.get(current) + 1 >= 4) {
                ans += 1;
                map = new HashMap();
            }
        }
        return ans;
    }
}
// @lc code=end

