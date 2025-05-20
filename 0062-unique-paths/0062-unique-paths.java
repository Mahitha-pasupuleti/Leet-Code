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