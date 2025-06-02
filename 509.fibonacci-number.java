/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int ans = fib(n - 1) + fib(n - 2);
        map.put(n, ans);
        return ans;
    }
}
// @lc code=end

