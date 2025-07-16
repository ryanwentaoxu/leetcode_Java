/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i] % k + k) % k;
            if (map.containsKey(prefixMod)) {
                ans += map.get(prefixMod);
            }
            map.put(prefixMod, map.getOrDefault(prefixMod, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

