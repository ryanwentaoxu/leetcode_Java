/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start
class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkIn;
    Map<Pair<String, String>, Pair<Integer, Integer>> travelTime;

    public UndergroundSystem() {
        checkIn = new HashMap();
        travelTime = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        int checkInTime = checkIn.get(id).getValue();
        String checkInStation = checkIn.get(id).getKey();
        Pair<String, String> p = new Pair(checkInStation, stationName);
        if (!travelTime.containsKey(p)) {
            travelTime.put(p, new Pair(t - checkInTime, 1));
        } else {
            Pair<Integer, Integer> pp = travelTime.get(p);
            travelTime.put(p, new Pair(pp.getKey() + t - checkInTime, pp.getValue() + 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> p = new Pair(startStation, endStation);
        double k = (double) travelTime.get(p).getKey();
        double v = (double) travelTime.get(p).getValue();
        return k / v;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

