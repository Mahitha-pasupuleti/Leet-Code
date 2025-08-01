class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> bfs = new ArrayDeque<>();
        int[][] directions = {{-1,0},{0,1},{0,-1},{1,0}};
        int level = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid.get(i).get(j) == 1 ) {
                    bfs.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int[] top = bfs.poll();
                int x = top[0];
                int y = top[1];
                grid.get(x).set(y, level);

                for ( int[] dir : directions ) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if ( dx<0 || dy<0 || dx>=n || dy>=m || visited[dx][dy] ) continue;
                    bfs.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
            level++;
        }
        for (List<Integer> row : grid) {
            System.out.println(row);
        }

        int[][] minSuccFactor= new int[n][m];
        for ( int i=0; i<n; i++ ) {
            Arrays.fill(minSuccFactor[i], Integer.MAX_VALUE);
        }

        minSuccFactor[0][0] = grid.get(0).get(0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        pq.add(new int[]{grid.get(0).get(0), 0, 0});

        boolean[][] visited2 = new boolean[n][m];

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int currSF = top[0];
            int x = top[1];
            int y = top[2];

            if (x == n - 1 && y == m - 1) return currSF;

            if (visited2[x][y]) continue;
            visited2[x][y] = true;

            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if ( dx<0 || dy<0 || dx>=n || dy>=m || visited2[dx][dy] ) continue;
                int minSF = Math.min(grid.get(dx).get(dy), minSuccFactor[x][y]);
                minSuccFactor[dx][dy] = minSF;
                pq.add(new int[]{minSF, dx, dy});
            }
        }
        
        return minSuccFactor[n-1][m-1];
    }
}