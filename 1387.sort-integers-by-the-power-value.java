/*
 * @lc app=leetcode id=1387 lang=java
 *
 * [1387] Sort Integers by The Power Value
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map;
    public int calcualte(int num) {
        if (map.containsKey(num)) return map.get(num);
        if (num % 2 == 0) {
            int next = calcualte(num / 2);
            map.put(num, next + 1);
            return map.get(num);
        }
        int next = calcualte(num * 3 + 1);
        map.put(num, next + 1);
        return map.get(num);
    }
    
    public int getKth(int lo, int hi, int k) {
        map = new HashMap();
        map.put(1, 0);

        Comparator<Map.Entry<Integer, Integer>> c = new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int k1 = o1.getKey();
                int k2 = o2.getKey();
                int v1 = o1.getValue();
                int v2 = o2.getValue();
                return v1 == v2 ? k1 - k2 : v1 - v2;
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(c);
        for (int i = lo; i <= hi; i++) {
            Map.Entry<Integer, Integer> current = Map.entry(i, calcualte(i));
            pq.offer(current);
        }
        int ans = -1;
        for (int i = 1; i <= k; i++) {
            ans = pq.poll().getKey();
        }
        return ans;
    }
}
// @lc code=end

