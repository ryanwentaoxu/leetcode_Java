/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    int[] nums;
    Map<Pair<Integer, Integer>, Integer> map;
    public NumArray(int[] nums) {
        this.nums = nums;
        map = new HashMap();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(new Pair(0, i), sum);
        }
    }
    
    public int sumRange(int left, int right) {
        int s1 = map.get(new Pair(0, left));
        int s2 = map.get(new Pair(0, right));
        return s2 - s1 + nums[left];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

