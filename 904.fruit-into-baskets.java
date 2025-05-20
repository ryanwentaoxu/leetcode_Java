/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        while (left <= right && right <= fruits.length) {
            if (map.size() <= 2) {
                int tmp = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    tmp += entry.getValue();
                }
                ans = Math.max(ans, tmp);
            }

            if (map.size() <= 2 && right < fruits.length) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                right += 1;
            } else {
                if (left == fruits.length) break;
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

