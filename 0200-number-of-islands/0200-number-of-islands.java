class Solution {
    private void dfs(char[][] grid, boolean[][] visited, int[][] directions, int x, int y) {
        if ( visited[x][y] ) return;
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=grid.length || dy>=grid[0].length || grid[dx][dy] == '0' ) continue;
            dfs(grid, visited, directions, dx, dy);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int noofIslands = 0;
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == '1' && !visited[i][j] ) {
                    noofIslands++;
                    dfs(grid, visited, directions, i, j);
                }
            }
        }
        return noofIslands;
    }
}