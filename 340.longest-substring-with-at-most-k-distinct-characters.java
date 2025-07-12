class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (left <= right && right <= s.length()) {
            if (map.size() <= k) ans = Math.max(ans, right - left);
            if (right < s.length() && map.size() <= k) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right += 1;
            } else {
                if (left == s.length()) break;
                int f = map.getOrDefault(s.charAt(left), 0);
                if (f == 1) map.remove(s.charAt(left));
                else map.put(s.charAt(left), f - 1);
                left += 1;
            }
        }
        return ans;
    }
}