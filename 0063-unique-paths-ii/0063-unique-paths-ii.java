class Solution {
    public int solve(int m, int n, int[][] obstacleGrid, int[][] dp) {
        if ( m == 0 || n == 0 ) return 0;
        if ( obstacleGrid[m-1][n-1] == 1 ) return 0;
        if ( dp[m][n] != -1 ) return dp[m][n];
        if ( m == 1 && n == 1 ) return 1;
        return dp[m][n] = solve(m, n-1, obstacleGrid, dp) + solve(m-1, n, obstacleGrid, dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m+1][n+1];
        for ( int i=0; i<m+1; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m, n, obstacleGrid, dp);
    }
}