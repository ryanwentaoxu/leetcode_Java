/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

class Solution {
    Map<String, Boolean> map;

    public boolean helper(String s, Set<String> wordDict) {
        if (s.length() == 0) return true;
        if (map.containsKey(s) == true) return map.get(s);
        boolean ret = false;
        for (int i = 0; i < s.length(); i++) {
            String current = s.substring(0, i + 1);
            if (wordDict.contains(current)) ret = ret || helper(s.substring(i + 1, s.length()), wordDict);
            if (ret == true) break;
        }
        map.put(s, ret);
        return ret;
    }
        
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap();
        Set<String> set = new HashSet();
        for (String ss : wordDict) set.add(ss);
        return helper(s, set);
    }
}
// @lc code=end

