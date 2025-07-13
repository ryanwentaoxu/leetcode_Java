/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int count(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, 1);
        }
        return map.size();
    }

    public int longestSubstring(String s, int k) {
        int total = count(s);
        int[] ncount = new int[26];
        Arrays.fill(ncount, 0);
        int ans = 0;
        for (int i = 1; i <= total; i++) {
            int kCount = 0;
            int unique = 0;
            int left = 0;
            int right = 0;
            Arrays.fill(ncount, 0);
            while (right < s.length()) {
                if (unique <= i) {
                    int idx = (int)(s.charAt(right) - 'a');
                    ncount[idx] += 1;
                    if (ncount[idx] == k) {
                        kCount += 1;
                    }
                    if (ncount[idx] == 1) {
                        unique += 1;
                    }
                    right += 1;
                } else {
                    int idx = (int)(s.charAt(left) - 'a');
                    ncount[idx] -= 1;
                    if (ncount[idx] == k - 1) {
                        kCount -= 1;
                    }
                    if (ncount[idx] == 0) {
                        unique -= 1;
                    }
                    left += 1;
                }
                if (unique == i && kCount == unique) {
                    ans = Math.max(ans, right - left);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

