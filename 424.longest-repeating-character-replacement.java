/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap();
        int ans = 0;
        for (right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(current));

            // check if it exceeds k times
            boolean isValid = (right - left + 1 - maxFreq) <= k;
            if (isValid == false) {
                char start = s.charAt(left);
                map.put(start, map.get(start) - 1);
                left += 1;
            }
            ans = right - left + 1;
        }
        return ans;
    }
}
// @lc code=end

