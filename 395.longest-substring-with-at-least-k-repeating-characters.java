/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            Arrays.fill(countMap, 0);
            int windowStart = 0;
            int windowEnd = 0;
            int idx=  0;
            int unique = 0;
            int countAtLeastK = 0;
            while (windowEnd < str.length) {
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique += 1;
                    countMap[idx] += 1;
                    if (countMap[idx] == k) countAtLeastK += 1;
                    windowEnd += 1;
                } else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK -= 1;
                    countMap[idx] -= 1;
                    if (countMap[idx] == 0) unique -= 1;
                    windowStart += 1;
                }
                if (unique == currUnique && unique == countAtLeastK) {
                    result = Math.max(windowEnd - windowStart, result);
                }
            }
        }
        return result;
    }
}
// @lc code=end

