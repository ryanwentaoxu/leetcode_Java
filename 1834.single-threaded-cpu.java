/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */

// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] newTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        
        Arrays.sort(newTasks, (a, b) -> a[0] - b[0]);
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(c);
        int[] ans = new int[newTasks.length];
        int index = 0;
        int time = 0;
        int i = 0;

        while (index < newTasks.length) {
            if (i < newTasks.length && pq.isEmpty() && time < newTasks[i][0]) time = newTasks[i][0];

            while (i < newTasks.length && time >= newTasks[i][0]) {
                pq.offer(newTasks[i]);
                i += 1;
            }

            int[] current = pq.poll();
            time = time + current[1];
            ans[index++] = current[2];
        }
        return ans;
    }
}
// @lc code=end

