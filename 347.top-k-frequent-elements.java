/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) list.add(entry);
        Map.Entry<Integer, Integer> target = qselect(list, freq.size() - k + 1);
        System.out.println(target.getKey());
        List<Integer> ret = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= target.getValue()) ret.add(entry.getKey());
        }
        int[] ans = new int[ret.size()];
        int index = 0;
        for (int n : ret) ans[index++] = n;
        return ans;
    }

    public Map.Entry<Integer, Integer> qselect(List<Map.Entry<Integer, Integer>> list, int k) {
        Random rnd = new Random();
        int pivotIndex = rnd.nextInt(list.size());
        List<Map.Entry<Integer, Integer>> left = new ArrayList();
        List<Map.Entry<Integer, Integer>> mid = new ArrayList();
        List<Map.Entry<Integer, Integer>> right = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() < list.get(pivotIndex).getValue()) {
                left.add(list.get(i));
            } else if (list.get(i).getValue() == list.get(pivotIndex).getValue()) {
                mid.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        if (left.size() >= k) {
            return qselect(left, k);
        } else if (left.size() + mid.size() < k) {
            return qselect(right, k - (left.size() + mid.size()));
        } else {
            return list.get(pivotIndex);
        }
    }
}
// @lc code=end

