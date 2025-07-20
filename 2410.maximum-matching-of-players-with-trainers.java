/*
 * @lc app=leetcode id=2410 lang=java
 *
 * [2410] Maximum Matching of Players With Trainers
 */

// @lc code=start
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int pIndex = players.length - 1;
        int tIndex = trainers.length - 1;
        int ans = 0;
        while (pIndex >= 0 && tIndex >= 0) {
            if (players[pIndex] <= trainers[tIndex]) {
                ans += 1;
                pIndex -= 1;
                tIndex -= 1;
            } else {
                pIndex -= 1;
            }
        }
        return ans;
    }
}
// @lc code=end

