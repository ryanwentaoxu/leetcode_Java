/*
 * @lc app=leetcode id=1751 lang=java
 *
 * [1751] Maximum Number of Events That Can Be Attended II
 */

// @lc code=start
class Solution {
    int[] map;
    int[][] memo;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        map = new int[events.length];
        memo = new int[events.length][k + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        for (int i = 0; i < events.length; i++) {
            search(events, i);
        }
        return dfs(0, k, events);
    }

    public int dfs(int index, int count, int[][] events) {
        if (index == events.length || count == 0) return 0;
        if (memo[index][count] != -1) return memo[index][count];
        int next = map[index];
        int current = Math.max(dfs(next, count - 1, events) + events[index][2], dfs(index + 1, count, events));
        memo[index][count] = current;
        return current;
    }

    public void search(int[][] events, int index) {
        int left = 0, right = events.length;
        int target = events[index][1];
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        map[index] = left;
    }
}
// @lc code=end

