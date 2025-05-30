/*
 * @lc app=leetcode id=3335 lang=java
 *
 * [3335] Total Characters in String After Transformations I
 */

// @lc code=start
class Solution {
    int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            cnt[(int)(current - 'a')] += 1;
        }
        
        for (int i = 1; i <= t; i++) {
            int[] tmp = new int[26];
            tmp[0] = cnt[25];
            tmp[1] = (cnt[0] + cnt[25]) % MOD;
            for (int j = 2; j < 26; j++) {
                tmp[j] = cnt[j - 1] % MOD;
            }
            cnt = tmp;
        }
        int ans = 0;
        for (int n : cnt) {
            ans = (ans + n) % MOD;
        }
        return ans;
    }
}
// @lc code=end

