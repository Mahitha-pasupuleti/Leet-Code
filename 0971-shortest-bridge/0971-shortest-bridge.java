class Solution {
    private void dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y, Queue<int[]> bfs) {
        visited[x][y] = true;
        bfs.add( new int[]{x, y});
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=grid.length || dy>=grid[0].length || grid[dx][dy] == 0 || visited[dx][dy] ) continue;
            dfs(grid, visited, directions, dx, dy, bfs);
        }
    }
    public int shortestBridge(int[][] grid) {
        // use dfs to mark one of the island as visited
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> bfs = new ArrayDeque<>();
        boolean oneIslandVisited = false;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 1 && !oneIslandVisited ) {
                    oneIslandVisited = true;
                    dfs(grid, visited, directions, i, j, bfs);
                    break;
                }
            }
        }

        int level = 0;

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();

            for ( int i=0; i<size; i++ ) {
                int[] curr = bfs.poll();
                int x = curr[0], y = curr[1];

                for ( int[] dir : directions ) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];

                    if ( dx<0 || dy<0 || dx>=grid.length || dy>=grid[0].length || visited[dx][dy] ) continue;
                    if ( grid[dx][dy] == 1 ) return level;
                    bfs.add( new int[]{dx, dy} );
                    visited[dx][dy] = true;
                }
            }

            level++;
        }

        return 0;
    }
}
/*
    [1,1,0]
    [0,0,0]
    [0,0,1]

    [1,1,1,1,1]
    [1,0,0,0,1]
    [1,0,1,0,1]
    [1,0,0,0,1]
*/