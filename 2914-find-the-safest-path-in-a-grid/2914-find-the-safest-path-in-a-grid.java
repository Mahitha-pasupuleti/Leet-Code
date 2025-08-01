class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Step 1: Multi-source BFS to compute safeness level from nearest thief
        Queue<int[]> bfs = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int level = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    bfs.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int[] top = bfs.poll();
                int x = top[0], y = top[1];
                grid.get(x).set(y, level);

                for (int[] dir : directions) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy]) continue;
                    bfs.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
            level++;
        }

        // Step 2: Max-heap Dijkstra to find path with max minimum safeness
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap on safeness
        boolean[][] visited2 = new boolean[n][m];
        pq.add(new int[]{grid.get(0).get(0), 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currSF = top[0];
            int x = top[1];
            int y = top[2];

            if (x == n - 1 && y == m - 1) return currSF; // Safest path found

            if (visited2[x][y]) continue;
            visited2[x][y] = true;

            for (int[] dir : directions) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited2[dx][dy]) continue;

                int minSF = Math.min(currSF, grid.get(dx).get(dy));
                pq.add(new int[]{minSF, dx, dy});
            }
        }

        return -1; // No path found (shouldn't happen per problem constraints)
    }
}