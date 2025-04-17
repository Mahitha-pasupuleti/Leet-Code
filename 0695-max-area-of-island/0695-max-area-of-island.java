class Solution {
    public int DFS(int[][] grid, boolean[][] visited, int[][] directions, int srX, int srY) {
        visited[srX][srY] = true;
        int area = 1;
        for ( int[] dir : directions ) {
            int dx = srX + dir[0], dy = srY + dir[1];
            if ( dx<0 || dx>=grid.length || dy<0 || dy>=grid[0].length || visited[dx][dy] || grid[dx][dy] != 1 ) continue;
            area += DFS(grid, visited, directions, dx, dy);
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        int max = 0;
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( !visited[i][j] && grid[i][j] == 1 ) {
                    max = Math.max(max, DFS(grid, visited, directions, i, j) );
                }
            }
        }

        return max;
    }
}