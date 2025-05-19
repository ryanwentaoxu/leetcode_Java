/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {

    TreeMap<Integer, Integer> calendar;
    

    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime);
        Integer next = calendar.ceilingKey(startTime);
        
        if ((prev == null || calendar.get(prev) <= startTime) && (next == null || next >= endTime)) {
            calendar.put(startTime, endTime);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
// @lc code=end

