/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

class Solution {
    public boolean isValid(String s) {
        long ret = 0;
        for (int i = 0;i < s.length(); i++) {
            ret += (long)(s.charAt(i) - '0') * (long)(s.charAt(i) - '0');
        }
        return ret == 1 ? true : false;
    }

    public long cal(String s) {
        long ret = 0;
        for (int i = 0;i < s.length(); i++) {
            ret += (long)(s.charAt(i) - '0') * (long)(s.charAt(i) - '0');
        }
        return ret;
    }


    public boolean isHappy(int n) {
        String s = String.valueOf(n);
        Set<String> visited = new HashSet<>();
        while (isValid(s) == false) {
            if (visited.contains(s) == true) return false;
            visited.add(s);
            s = String.valueOf(cal(s));
        }
        return true;
    }
}
// @lc code=end

