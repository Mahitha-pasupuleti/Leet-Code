class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};
        Queue<int[]> bfs = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int level = 1;

        if ( grid[0][0] == 1 ) return -1;

        bfs.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while ( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int[] curr = bfs.poll();
                int x = curr[0], y = curr[1];
                if ( x == n-1 && y == m-1 ) return level;
                for ( int[] dir : directions ) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if ( dx<0 || dy<0 || dx>=n || dy>=m || grid[dx][dy]==1 || visited[dx][dy] ) continue;
                    bfs.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
            level++;
        }

        return -1;
    }
}

// 8-directionally ( Horizontal, Vertical, Diagonal )
// {{-1,0},{0,-1},{1,0},{0,1},{-1,-1},{1,1}}
/*
    [0,1,1,0,0,0]
    [0,1,0,1,1,0]
    [0,1,1,0,1,0]
    [0,0,0,1,1,0]
    [1,1,1,1,1,0]
    [1,1,1,1,1,0]
*/