class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0'; // mark as visited

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m &&
                    newY >= 0 && newY < n &&
                    grid[newX][newY] == '1') {

                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = '0'; // mark visited
                }
            }
        }
    }
}
