class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        if ((n > 1 && grid[1][0] > 1) && (m > 1 && grid[0][1] > 1))
            return -1;

        int[][] minTime = new int[n][m];
        for ( int i=0; i<n; i++ ) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.add(new int[]{0, 0, 0});

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int time = top[0];
            int x = top[1];
            int y = top[2];

            if ( x == n-1 && y == m-1 ) return time;

            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if ( dx<0 || dy<0 || dx>=n || dy>=m ) continue;

                int arrivalTime = time;
                if ( grid[dx][dy] <= time+1 ) {
                   arrivalTime++;
                } else {
                    int wait = grid[dx][dy] - time;
                    if ( wait % 2 == 0 ) {
                       arrivalTime = grid[dx][dy] + 1;
                    } else {
                       arrivalTime =  grid[dx][dy];
                    }
                }

                if ( arrivalTime < minTime[dx][dy] ) {
                    minTime[dx][dy] = arrivalTime;
                    pq.add(new int[]{arrivalTime, dx, dy});
                }

            }
        }

        return -1;
    }
}