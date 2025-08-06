class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] minCost = new int[n][m];
        for ( int i=0; i<n; i++ ) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
            minCost[0][0] = 0;
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.add(new int[]{0, 0, 0});

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int cost = top[0];
            int x = top[1];
            int y = top[2];

            for ( int i=0; i<4; i++ ) {
                int currCost = cost;
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];
                if ( dx<0 || dy<0 || dx>=n || dy>=m ) continue;

                if ( grid[x][y] != i+1 ) currCost += 1;
                if ( minCost[dx][dy] > currCost ) {
                    minCost[dx][dy] = currCost;
                    pq.add(new int[]{currCost, dx, dy});
                }
            }
        }

        return minCost[n-1][m-1];
    }
}