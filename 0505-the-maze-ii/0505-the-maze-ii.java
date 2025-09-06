class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

        int[][] distMatrix = new int[m][n];
        for ( int i=0; i<m; i++ ) {
            Arrays.fill(distMatrix[i], Integer.MAX_VALUE);
        }
        distMatrix[start[0]][start[1]] = 0; // make intial positon distance as 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[2] - b[2])
        ); // store: x, y, dist

        pq.add(new int[]{start[0], start[1], 0});

        while ( !pq.isEmpty() ) {
            int[] pos = pq.poll();
            if ( pos[0] == destination[0] && pos[1] == destination[1] ) return pos[2];
            for ( int[] dir : directions ) {
                int steps = pos[2]; // steps took to reach previous position
                int dx = dir[0] + pos[0];
                int dy = dir[1] + pos[1];
                while ( dx>=0 && dy>=0 && dx<m && dy<n && maze[dx][dy] == 0 ) {
                    dx += dir[0];
                    dy += dir[1];
                    steps++;
                }
                dx -= dir[0];
                dy -= dir[1];
                if ( steps >= distMatrix[dx][dy] ) continue;
                distMatrix[dx][dy] = steps;
                pq.add(new int[]{dx, dy, steps});
            }
        }

        return -1;
    }
}