class Solution {
    // private int getDistanceBWCells(int x1, int y1, int x2, int y2) {
    //     return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    // }
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> bfs = new ArrayDeque<>();
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][m];

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 1 ) {
                    bfs.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (bfs.isEmpty() || bfs.size() == n * n) return -1;

        int maxDistance = -1;

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();

            for ( int i=0; i<size; i++ ) {
                int[] curr = bfs.poll();
                int x = curr[0];
                int y = curr[1];

                for ( int[] dir : directions ) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if ( dx<0 || dy<0 || dx>=n || dy>=m || grid[dx][dy]==1 || visited[dx][dy] ) continue;

                    bfs.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }

            maxDistance++;
        }

        return maxDistance;
    }
}