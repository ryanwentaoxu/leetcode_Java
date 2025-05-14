/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public boolean include(Map<Character, Integer> sCount, Map<Character, Integer> pCount) {
        if (sCount.size() > pCount.size()) return false;
        for (Map.Entry<Character, Integer> entry : sCount.entrySet()) {
            char c = entry.getKey();
            int v = entry.getValue();
            if (pCount.containsKey(c)) {
                if (pCount.get(c) >= v) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> sCount = new HashMap();
        Map<Character, Integer> pCount = new HashMap();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        List<Integer> ret = new ArrayList();
        while (left <= right && right <= s.length()) {
            if (sCount.equals(pCount)) {
                ret.add(left);
            } 
            if (left == s.length()) break;
            if (include(sCount, pCount) && right < s.length()) {
                char c = s.charAt(right);
                sCount.put(c, sCount.getOrDefault(c, 0) + 1);
                right += 1;
            } else {
                char c  = s.charAt(left);
                sCount.put(c, sCount.get(c) - 1);
                if (sCount.get(c) == 0) sCount.remove(c);
                left += 1;
            }
        }
        return ret;
    }
}
// @lc code=end

