class Solution {
    // in second grid, find all 1's. If the same grid in grid1 is 1 as well start the island dfs, each and everycell should aslso be one int grid1 else leasve
    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int[][] directions, int x, int y) {
        boolean isSubIsland = grid1[x][y] == 1;
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=grid2.length || dy>=grid2[0].length || grid2[dx][dy] == 0 || visited[dx][dy] ) continue;
            if ( !dfs(grid1, grid2, visited, directions, dx, dy ) ) {
                isSubIsland = false;
            }
        }
        return isSubIsland;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int subIslandCount = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid2[i][j] == 1 && grid1[i][j] == 1 && !visited[i][j] ) {
                    if ( dfs(grid1, grid2, visited, directions, i, j) ) subIslandCount++;
                }
            }
        }

        return subIslandCount;
    }
}