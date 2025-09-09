class Solution {
    int[][] directions = {{0,1},{1,0}}; // 0:right, 1:down
    int[][][] dp;
    int mod = 1_000_000_007;

    private int solve(int x, int y, int currDir, int[][] grid) {

        int m = grid.length, n = grid[0].length;

        if ( x == m-1 && y == n-1 ) return 1;
        if ( currDir != -1 && dp[x][y][currDir] != -1 ) return dp[x][y][currDir];

        int result = 0;

        for ( int i=0; i<2; i++ ) {
            int[] dir = directions[i];
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=m || dy>=n ) continue;

            int movedDir = i;
            while (dx >= 0 && dy >= 0 && dx < m && dy < n && grid[dx][dy] == 1) {
                if (movedDir == 0) { // moving right → bounce down
                    dx++;
                    movedDir = 1;
                } else if (movedDir == 1) { // moving down → bounce right
                    dy++;
                    movedDir = 0;
                }
            }

            if (dx >= 0 && dy >= 0 && dx < m && dy < n) {
                result = (result + solve(dx, dy, movedDir, grid)) % mod;
            }
        }

        if ( currDir != -1 ) {
            dp[x][y][currDir] = result;
        }
        return (int)result;

    }

    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        dp = new int[m][n][2]; // two directions 0 & 1

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    
        return solve(0, 0, -1, grid);
    }
}

        // for ( int k=0; k<2; k++ ) {
        //     for ( int i=0; i<m; i++ ) {
        //         for ( int j=0; j<n; j++ ) {
        //             System.out.print(dp[i][j][k] + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
