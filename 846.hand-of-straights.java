/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        Queue<Integer> groupStartQueue = new LinkedList<>();
        int lastCard = -1;
        int currentOpenGroups = 0;
        for (Map.Entry<Integer, Integer> entry : cardCount.entrySet()) {
            int currentCard = entry.getKey();
            if ((currentOpenGroups > 0 && currentCard > lastCard + 1) || currentOpenGroups > cardCount.get(currentCard)) {
                return false;
            }
            groupStartQueue.offer(cardCount.get(currentCard) - currentOpenGroups);
            lastCard = currentCard;
            currentOpenGroups = cardCount.get(currentCard);
            if (groupStartQueue.size() == groupSize) {
                currentOpenGroups -= groupStartQueue.poll();
            }
        }
        return currentOpenGroups == 0;
    }
}
// @lc code=end

