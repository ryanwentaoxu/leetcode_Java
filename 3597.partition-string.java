/*
 * @lc app=leetcode id=3597 lang=java
 *
 * [3597] Partition String 
 */

// @lc code=start
class Solution {
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet();
        int index = 0;
        int seg = 0;
        List<String> list = new ArrayList();
        while (index < s.length()) {
            String current = s.substring(index, index + seg + 1);
            if (!seen.contains(current)) {
                seen.add(current);
                list.add(current);
                index += 1;
            } else {
                while (seen.contains(current) && index + seg + 1 < s.length()) {
                    seg += 1;
                    current = s.substring(index, index + seg + 1);
                }
                if (!seen.contains(current)) {
                    seen.add(current);
                    list.add(current);
                }
                index = index + seg + 1;
                seg = 0;
            }
        }
        return list;
    }
}
// @lc code=end

