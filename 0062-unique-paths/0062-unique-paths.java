class Solution {
    public int uniquePaths(int m, int n) {
        // we need two loops
        int[][] dp = new int[m][n];
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( i == 0 || j == 0 ) dp[i][j] = 1;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}

/*
class Solution {
    int[][] dp;
    public int solve(int m, int n) {
        if ( m == 0 || n == 0 ) return 0; // valid
        if ( dp[m][n] != -1 ) return dp[m][n];
        if ( m == 1 && n == 1 ) return 1; // invalid
        return dp[m][n] = solve(m, n-1) + solve(m-1, n); // similar to fibanocci
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for ( int i=0; i<m+1; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m, n);
    }
}
*/