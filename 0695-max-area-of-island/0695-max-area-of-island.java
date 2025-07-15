class Solution {
    private int dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y) {
        if ( visited[x][y] ) return 0;
        visited[x][y] = true;
        int minIslands = 1; // everytime he visits an island, we count it
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=grid.length || dy>=grid[0].length || grid[dx][dy] == 0 ) continue;
            minIslands += dfs(grid, visited, directions, dx, dy); // so no.of islands visited from given island are returned in the dfs
        }
        return minIslands;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int maxArea = 0;
        for (int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 1 && !visited[i][j] ) {
                    int area = dfs(grid, visited, directions, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}