/*
 * @lc app=leetcode id=1639 lang=java
 *
 * [1639] Number of Ways to Form a Target String Given a Dictionary
 */

// @lc code=start
class Solution {
    public int numWays(String[] words, String target) {
        int[][] map = new int[words[0].length()][26];
        for (int[] m : map) Arrays.fill(m, 0);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                map[i][c - 'a'] += 1;
            }
        }

        long[] prev = new long[target.length() + 1];
        long[] current = new long[target.length() + 1];
        int mod = 1000000000 + 7;

        prev[0] = 1;
        for (int i = 0; i < words[0].length(); i++) {
            current = Arrays.copyOf(prev, target.length() + 1);

            for (int j = 1; j < target.length() + 1; j++) {
                char c = target.charAt(j - 1);
                int index = c - 'a';
                current[j] += prev[j - 1] * map[i][index] % mod; 
                current[j] %= mod;
            }

            prev = Arrays.copyOf(current, target.length() + 1);
        }
        return (int)prev[target.length()];
    }
}
// @lc code=end

