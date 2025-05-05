/*
 * @lc app=leetcode id=1898 lang=java
 *
 * [1898] Maximum Number of Removable Characters
 */

// @lc code=start
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] ss = s.toCharArray();
        int left = 0;
        int right = removable.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            for (int i = 0; i <= mid; i++) ss[removable[i]] = '/';
            if (check(ss, p)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            for (int i = 0; i <= mid; i++) ss[removable[i]] = s.charAt(removable[i]);
        }
        return left;
    }

    public boolean check(char[] s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < s.length && pIndex < p.length()) {
            if (s[sIndex] == '/') {
                sIndex += 1;
                continue;
            } else {
                if (s[sIndex] != p.charAt(pIndex)) {
                    sIndex += 1;
                } else {
                    sIndex += 1;
                    pIndex += 1;
                }
            }
        }
        return pIndex == p.length() ? true : false;
    }
}
// @lc code=end

