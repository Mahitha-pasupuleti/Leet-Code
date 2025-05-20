class Solution {
    int[][] dp;
    public int solve(int[] coins, int amount, int n) {
        if ( n <= 0 ) return 0;
        if ( amount == 0 ) return 1; // valid
        if ( dp[n][amount] != -1 ) return dp[n][amount];
        if ( coins[n-1] <= amount ) {
            return dp[n][amount] = solve(coins, amount-coins[n-1], n) + solve(coins, amount, n-1);
        }
        return dp[n][amount] = solve(coins, amount, n-1);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for ( int i=0; i<n+1; i++ ) {
            for ( int j=0; j<amount+1; j++ ) {
                dp[i][j] = -1;
            }
        }
        return solve(coins, amount, n);
    }
}