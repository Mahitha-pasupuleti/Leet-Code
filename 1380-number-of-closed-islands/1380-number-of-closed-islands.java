class Solution {
    private boolean dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y) {

        if ( x<0 || y<0 || x>=grid.length || y>=grid[0].length ) return false; // border
        if ( grid[x][y] == 1 || visited[x][y] ) return true; // not border
        visited[x][y] = true;
        boolean isClosed = true;

        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( !dfs(grid, visited, directions, dx, dy) ) isClosed = false; 
            // once isClosed is false, it cannot be changed back to true, it will be recursively returned to ultimately give false
        }

        return isClosed;

    }
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        int noofClosedIslands = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 0 && !visited[i][j] ) {
                    if ( dfs(grid, visited, directions, i, j) ) noofClosedIslands++;
                }
            }
        }

        return noofClosedIslands;
    }
}