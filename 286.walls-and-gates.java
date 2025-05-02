class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList();
        Set<Pair<Integer, Integer>> visited = new HashSet();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited.add(new Pair(i, j));
                }
            }
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (q.size() != 0) {
            for (int level = q.size(); level > 0; level--) {
                int[] current = q.poll();
                // visited.add(current);
                for (int[] d : directions) {
                    int nx = current[0] + d[0];
                    int ny = current[1] + d[1];
                    if (nx < 0 || nx >= rooms.length || ny < 0 || ny >= rooms[0].length) {
                        continue;
                    }
                    if (rooms[nx][ny] == 0 || rooms[nx][ny] == -1) {
                        continue;
                    }

                    if (visited.contains(new Pair(nx, ny))) {
                        continue;
                    }
                    rooms[nx][ny] = Math.min(rooms[nx][ny], 1 + rooms[current[0]][current[1]]);
                    q.add(new int[]{nx, ny});
                    visited.add(new Pair(nx, ny));
                }
            }

        }
    }
}