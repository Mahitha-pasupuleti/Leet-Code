class Solution {
    int[] dp;
    public int solve(int n) {
        if ( n < 0 ) return 0;
        if ( dp[n] != -1 ) return dp[n];
        if ( n == 0 ) return 1;
        return dp[n] = solve(n-1) + solve(n-2);
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        for ( int i=0; i<n+1; i++ ) {
            dp[i] = -1;
        }
        return solve(n);
    }
}