class Solution {
    // find path with least maximum height
    // time to wait
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        int[][] minTime = new int[n][m];
        for ( int i=0; i<n; i++ ) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.add(new int[]{grid[0][0], 0, 0});

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int currentTime = top[0];
            int x = top[1];
            int y = top[2];

            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if ( dx<0 || dy<0 || dx>=n || dy>=m ) continue;

                int time = Math.max(currentTime, grid[dx][dy]);

                if ( minTime[dx][dy] > time ) {
                    minTime[dx][dy] = time;
                    pq.add(new int[]{time, dx, dy});
                }
            }
        }

        return minTime[n-1][m-1];
    }
}