/*
 * @lc app=leetcode id=3480 lang=java
 *
 * [3480] Maximize Subarrays After Removing One Conflicting Pair
 */

// @lc code=start
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Long>> list = new ArrayList();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList());
        }

        for (int[] pair : conflictingPairs) {
            long a = Math.min(pair[0], pair[1]);
            long b = Math.max(pair[0], pair[1]);
            list.get((int)b).add(a);
        }

        long ans = 0;
        long top1 = 0;
        long top2 = 0;
        long[] bonus = new long[n + 1];
        for (int b = 1; b <= n; b++) {
            for (long a : list.get(b)) {
                if (a > top1) {
                    top2 = top1;
                    top1 = a;
                } else if (a > top2) {
                    top2 = a;
                }
            }

            ans += (long) b - top1;
            if (top1 > 0) {
                bonus[(int)top1] += top1 - top2;
            }
        }

        long mb = 0;
        for (long b : bonus) mb = Math.max(b, mb);
        return ans + mb;

    }
}
// @lc code=end

