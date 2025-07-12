/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap();
        while (left <= right && right <= s.length()) {
            if (map.size() == right - left) {
                ans = Math.max(ans, map.size());
            }
            if (right < s.length() && !map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
                right += 1;
            } else {
                if (left == s.length()) break;
                map.remove(s.charAt(left));
                left += 1;
            }
        }

        return ans;
    }
}
// @lc code=end

