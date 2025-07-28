/*
 * @lc app=leetcode id=2402 lang=java
 *
 * [2402] Meeting Rooms III
 */

// @lc code=start
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        PriorityQueue<long[]> usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) unusedRooms.offer(i);

        Arrays.sort(meetings, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room] += 1;
            } else {
                long rt = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[]{end - start + rt, room});
                meetingCount[room] += 1;
            }
        }

        int ans = 0;
        int num = 0;
        for (int i = 0; i < meetingCount.length; i++){
            if (meetingCount[i] > num) {
                num = meetingCount[i];
                ans = i;
            }
        }
        return ans;

    }
}
// @lc code=end

