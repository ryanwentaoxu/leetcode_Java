/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> diff1 = new HashMap();
        Map<Character, Character> diff2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            char v = t.charAt(i);
            if (diff1.getOrDefault(k, v) != v) return false;
            if (diff2.getOrDefault(v, k) != k) return false;
            diff1.put(k, v);
            diff2.put(v, k);
        }
        return true;
    }
}
// @lc code=end

