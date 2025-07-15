class Solution {
    public void wallsAndGates(int[][] rooms) {

        int n = rooms.length, m = rooms[0].length;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> bfs = new ArrayDeque<>();

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( rooms[i][j] == 0 ) {
                    bfs.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int[] top = bfs.poll();
                rooms[top[0]][top[1]] = level;
                for ( int[] dir : directions ) {
                    int dx = top[0] + dir[0];
                    int dy = top[1] + dir[1];
                    if ( dx<0 || dy<0 || dx>=n || dy>=m || rooms[dx][dy] == 0 || rooms[dx][dy] == -1 || visited[dx][dy] ) continue;
                    visited[dx][dy] = true;
                    bfs.add(new int[]{dx, dy});
                }
            }
            level++;
        }

    }
}