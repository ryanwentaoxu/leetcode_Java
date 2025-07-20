/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        List<Integer> list = new ArrayList();
        for (int c : citations) list.add(c);
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans = Math.max(ans, Math.min(entry.getKey(), entry.getValue()));
        }
        return ans;

    }
}
// @lc code=end

