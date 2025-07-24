/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList();
        if (start == nums.length) return res;
        long average_value = target / k;
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }
        if (k == 2) return twoSum(nums, target, start);

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                List<List<Integer>> ks = kSum(nums, target - nums[i], i + 1, k - 1);
                for (List<Integer> subset : ks) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> list = new ArrayList();
        Set<Integer> set = new HashSet();
        for (int i = start; i < nums.length; i++) {
            int prev = (int)target - nums[i];
            if (set.contains(prev)) {
                if (list.size() == 0 || list.get(list.size() - 1).get(1) != nums[i]) list.add(new ArrayList(Arrays.asList(prev, nums[i])));
            }
            set.add(nums[i]);
        }
        return list;
    }
}
// @lc code=end

