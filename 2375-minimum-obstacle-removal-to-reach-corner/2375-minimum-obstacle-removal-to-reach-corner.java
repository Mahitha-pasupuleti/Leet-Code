class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] minObs = new int[n][m];
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        for ( int i=0; i<n; i++ ) {
            Arrays.fill(minObs[i], Integer.MAX_VALUE);
        }
        minObs[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] - b[0])
        );
        pq.add(new int[]{0, 0, 0});

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int dist = top[0];
            int x = top[1];
            int y = top[2];

            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if ( dx<0 || dy<0 || dx>=n || dy>=m ) continue;
                int newDist = dist;
                if ( grid[dx][dy] == 1 ) {
                    newDist += 1;
                }
                if ( minObs[dx][dy] > newDist ) {
                    minObs[dx][dy] = newDist;
                    pq.add(new int[]{newDist, dx, dy});
                }
            }
        }

        return minObs[n-1][m-1];
    }
}