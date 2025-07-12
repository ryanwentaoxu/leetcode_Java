/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap(); 
        List<int[]> list = new ArrayList();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] current = map.getOrDefault(s.charAt(i), new int[]{-1, -1});
            if (current[0] == -1) {
                current[0] = i;
                current[1] = i;
                list.add(current);
            } else {
                current[1] = i;
            }
            map.put(s.charAt(i), current);
        }

        List<int[]> ret = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (ret.size() == 0) {
                ret.add(list.get(i));
            } else {
                if (ret.get(ret.size() - 1)[1] > list.get(i)[0]) {
                    ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1], list.get(i)[1]);
                } else {
                    ret.add(list.get(i));
                }
            }
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < ret.size(); i++) {
            ans.add(ret.get(i)[1] - ret.get(i)[0] + 1);
        }
        return ans;
    }
}
// @lc code=end

