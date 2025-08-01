class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int[][] routeEffort = new int[n][m];
        for (int[] row : routeEffort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new int[]{0, 0, 0}); // effort, x, y
        routeEffort[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int effort = top[0];
            int x = top[1];
            int y = top[2];

            if (x == n - 1 && y == m - 1) return effort;

            for (int[] dir : directions) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) continue;

                int currEffort = Math.max(effort, Math.abs(heights[dx][dy] - heights[x][y]));

                if (currEffort < routeEffort[dx][dy]) {
                    routeEffort[dx][dy] = currEffort;
                    pq.add(new int[]{currEffort, dx, dy});
                }
            }
        }

        return 0; // This line is unreachable, but required syntactically
    }
}