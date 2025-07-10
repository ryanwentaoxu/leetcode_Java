/*
 * @lc app=leetcode id=3557 lang=java
 *
 * [3557] Find Maximum Number of Non Intersecting Substrings
 */

// @lc code=start
class Solution {
    public int maxSubstrings(String word) {
        int res = 0;
        String s = word;
        int n = s.length();
        Map<Character, Integer> pos = new HashMap();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!pos.containsKey(c)) {
                pos.put(c, i);
            } else if (i - pos.get(c) + 1 >= 4) {
                res += 1;
                pos.clear();
            }
        }
        return res;
    }
}
// @lc code=end

