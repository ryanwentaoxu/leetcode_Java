/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean include(Map<Character, Integer> map, Map<Character, Integer> s) {
        for (Map.Entry<Character, Integer> entry : s.entrySet()) {
            if (map.containsKey(entry.getKey()) == true && map.get(entry.getKey()) >= entry.getValue()) {
                continue;
            } else return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> tt = new HashMap<>();
        Map<Character, Integer> ss = new HashMap<>();
        for (char c : t.toCharArray()) {
            tt.put(c, tt.getOrDefault(c, 0) + 1);
        }
        String ret = s;
        boolean isFound = false;
        while (left <= right && right <= s.length()) {
            
            if (include(ss, tt) == true) {
                isFound = true;
                if (s.substring(left, right).length() <= ret.length()) {
                    ret = s.substring(left, right);
                }

                ss.put(s.charAt(left), ss.get(s.charAt(left)) - 1);
                if (ss.get(s.charAt(left)) == 0) ss.remove(s.charAt(left));
                left += 1;
            } else {
                if (right >= s.length()) break;
                ss.put(s.charAt(right), ss.getOrDefault(s.charAt(right), 0) + 1);
                right += 1;
            }
        }
        return isFound == true ? ret : "";
    }
}
// @lc code=end

