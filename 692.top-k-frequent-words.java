/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        Comparator<Map.Entry<String, Integer>> c = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                if (m1.getValue() == m2.getValue()) return m1.getKey().compareTo(m2.getKey());
                return -m1.getValue() + m2.getValue();
            }
        };

        Comparator<String> c2 = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) return s1.compareTo(s2);
                return map.get(s2) - map.get(s1);
            }
        };

        List<Map.Entry<String, Integer>> l = new ArrayList();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            l.add(entry);
        }
        Collections.sort(l, c);

        List<String> ret = new ArrayList();
        for (int i = 1; i <= Math.min(k, l.size()); i++) {
            ret.add(l.get(i - 1).getKey());
        }
        
        Collections.sort(ret, c2);
        return ret;
    }
}
// @lc code=end

