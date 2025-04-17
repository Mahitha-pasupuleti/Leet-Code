class Solution {
    int perimeter = 0;
    public void DFS(int[][] grid, boolean[][] visited, int sourceX, int sourceY, int m, int n, int[][] directions) {
        visited[sourceX][sourceY] = true;
        for ( int[] dir : directions ) {
            int dx = sourceX + dir[0];
            int dy = sourceY + dir[1];
            if ( dx < 0 || dx >= m || dy < 0 || dy >= n || grid[dx][dy] == 0 ) {
                perimeter++;
                continue;
            }
            if ( visited[dx][dy] ) continue;
            DFS(grid, visited, dx, dy, m, n, directions);
        }
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 1 ) {
                    DFS(grid, visited, i, j, m, n, directions);
                    return perimeter;
                }
            }
        }

        return 0;
    }
}