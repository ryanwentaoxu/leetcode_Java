/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    Map<Character, Integer> map;
    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                char nc = s.charAt(i + 1);
                if (c == 'I' && nc == 'V') {
                    ans += 4;
                    i = i + 2;
                    continue;
                }
                if (c == 'I' && nc == 'X') {
                    ans += 9;
                    i = i + 2;
                    continue;
                }
                if (c == 'X' && nc == 'L') {
                    ans += 40;
                    i = i + 2;
                    continue;
                }
                if (c == 'X' && nc == 'C') {
                    ans += 90;
                    i = i + 2;
                    continue;
                }
                if (c == 'C' && nc == 'D') {
                    ans += 400;
                    i = i + 2;
                    continue;
                }

                if (c == 'C' && nc == 'M') {
                    ans += 900;
                    i = i + 2;
                    continue;
                }

                ans += map.get(c);
                i += 1;
            } else {
                ans += map.get(c);
                i += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

