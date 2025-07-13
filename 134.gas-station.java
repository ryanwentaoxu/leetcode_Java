/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public Pair<Integer, Boolean> helper(int[] gas, int[] cost, int start) {
        int total = gas.length;
        int acc = gas[start];
        int index = start;
        index = (index + 1) % total;
        while (true) {
            acc = acc - cost[index - 1 < 0 ? total - 1 : index - 1];
            if (acc < 0) return new Pair(index, false);
            if (index == start) break;
            acc = acc + gas[index];
            index = (index + 1) % total;
        }
        return new Pair(start, true);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        while (true) {
            Pair<Integer, Boolean> p = helper(gas, cost, index);
            if (p.getValue()) return index;
            if (p.getKey() <= index) break;
            index = p.getKey();
        }
        return -1;
    }
}
// @lc code=end

