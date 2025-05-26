/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 */

// @lc code=start
class Solution {
    public int diff(String t1, String t2) {
        int h1 = Integer.valueOf(t1.substring(0, 2));
        int h2 = Integer.valueOf(t2.substring(0, 2));
        int m1 = Integer.valueOf(t1.substring(3, 5));
        int m2 = Integer.valueOf(t2.substring(3, 5));
        int ans = 0;
        if (h2 > h1) {
            ans = 60 - m1 + m2;
            ans += (h2 - h1 - 1) * 60; 
        } else {
            ans = m2 - m1;
        }
        return ans;
    }
    public String parse(String t) {
        if (t.equals("00:00")) return "24:00";
        return t;
    }
    public int findMinDifference(List<String> timePoints) {
        for (int i = 0; i < timePoints.size(); i++) {
            timePoints.set(i, parse(timePoints.get(i)));
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int n = timePoints.size();
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int current = diff(timePoints.get(i), timePoints.get(i + 1));
            current = Math.min(current, 1440 - current);
            ans = Math.min(ans, diff(timePoints.get(i), timePoints.get(i + 1)));
        }
        int current = diff(timePoints.get(0), timePoints.get(n - 1));
        current = Math.min(current, 1440 - current);
        ans = Math.min(ans, current);
        return ans;
    }
}
// @lc code=end

