/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.Map;

class Solution {
    public boolean equal(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
            if (m1.containsKey(entry.getKey()) == true && m1.get(entry.getKey()) == entry.getValue()) {
                continue;
            } else {
                return false;
            }
        }
        if (m1.keySet().size() == m2.keySet().size()) return true;
        return false;
    }

    public boolean include(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (m2.containsKey(entry.getKey()) == true && m2.get(entry.getKey()) <= entry.getValue()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap();
        Map<Character, Integer> m2 = new HashMap();

        int left = 0;
        int right = 0;

        for (char c : s1.toCharArray()) {
            m2.put(c, m2.getOrDefault(m2, 0) + 1);
        }

        while (left <= right && right <= s2.length()) {
            
            if (equal(m1, m2) == true) return true;

            if (include(m1, m2) == true) {
                if (right == s2.length()) break;
                m1.put(s2.charAt(right), m1.getOrDefault(s2.charAt(right), 0) + 1);
                right += 1;
            } else {
                char c = s2.charAt(left);
                int v = m1.get(c);
                if (v == 1) m1.remove(c);
                else m1.put(c, v - 1);
                left += 1;
            }
        }
        return false;
    }
}
// @lc code=end

