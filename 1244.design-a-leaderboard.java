class Leaderboard {
    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;

    public Leaderboard() {
        scores = new HashMap();
        sortedScores = new TreeMap(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            sortedScores.put(score, sortedScores.getOrDefault(score, 0) + 1);
        } else {
            int preScore = scores.get(playerId);
            
            int preCount = sortedScores.get(preScore);
            if (preCount == 1) {
                sortedScores.remove(preScore);
            } else {
                sortedScores.put(preScore, preCount - 1);
            }
            scores.put(playerId, score + preScore);
            sortedScores.put(score + preScore, sortedScores.getOrDefault(score + preScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int k = K;
        int ans = 0;
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : sortedScores.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                ans += val;
                totalCount += 1;
                
                if (totalCount == k) return ans;
            }
            
            if (totalCount == k) return ans;
        }
        return ans;
    }
    
    public void reset(int playerId) {
        int preScore = scores.get(playerId);
        scores.put(playerId, 0);
        sortedScores.put(preScore, sortedScores.getOrDefault(preScore, 0) - 1);
        if (sortedScores.get(preScore) == 0) sortedScores.remove(preScore);
        sortedScores.put(0, sortedScores.getOrDefault(0, 0) + 1);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */