class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> bfs = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        bfs.add(start);
        visited[start[0]][start[1]] = true;


        while ( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int[] pos = bfs.poll();
                if ( pos[0] == destination[0] && pos[1] == destination[1] ) return true;
                for ( int[] dir: directions ) {
                    int dx = pos[0] + dir[0];
                    int dy = pos[1] + dir[1];
                    while ( dx>=0 && dy>=0 && dx<m && dy<n && maze[dx][dy] == 0 ) {
                        dx += dir[0];
                        dy += dir[1];
                    }
                    dx -= dir[0];
                    dy -= dir[1];
                    if ( !visited[dx][dy] )  {
                        visited[dx][dy] = true;
                        bfs.add(new int[]{dx, dy});
                    }
                }
            }
        }

        return false;
    }
}