class Solution {
    int[] dp;
    public int solve(int n) { // 4 // 3
    if ( dp[n] != -1 ) return dp[n];
        if ( n == 0 ) return 0;
        if ( n == 1 || n == 2 ) return 1;
        return dp[n] = solve(n-1) + solve(n-2) + solve(n-3); // 3 + 2 + 1 // 2 + 1 + 0
    }
    public int tribonacci(int n) {
        dp = new int[n+1];
        for ( int i=0; i<n+1; i++ ) {
            dp[i] = -1;
        }
        return solve(n);
    }
}