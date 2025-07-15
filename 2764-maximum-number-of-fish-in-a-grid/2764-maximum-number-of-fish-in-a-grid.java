class Solution {
    private int dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y) {
        if ( visited[x][y] ) return 0;
        visited[x][y] = true;
        int fishCount = grid[x][y]; // teh no.of fishes whwn u visit a cell which has fishes
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=grid.length || dy>=grid[0].length || grid[dx][dy] == 0 ) continue;
            fishCount += dfs(grid, visited, directions, dx, dy); // all the fishes u can catch by visiting a given cell
        }
        return fishCount;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int maxFishes = 0;
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] > 0 && !visited[i][j] ) {
                    maxFishes = Math.max( maxFishes, dfs(grid, visited, directions, i, j) );
                }
            }
        }
        return maxFishes;
    }
}