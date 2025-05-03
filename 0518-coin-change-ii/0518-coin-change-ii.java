class Solution {
    int[][] dp;
    public int subsetSum(int[] coins, int amount, int n) {
        if ( amount == 0 ) return 1;
        if ( n == 0 ) return 0;

        if ( dp[n][amount] != -1 ) return dp[n][amount];

        if ( coins[n-1] <= amount ) { // n-1 since indexing differs in main coins[] and dp
            return dp[n][amount] = subsetSum(coins, amount-coins[n-1], n) + subsetSum(coins, amount, n-1);
        }
        return dp[n][amount] = subsetSum(coins, amount, n-1);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for ( int i=0; i<n+1; i++) {
            for ( int j=0; j<amount+1; j++ ) {
                dp[i][j] = -1;
            }
        }
        return subsetSum(coins, amount, n);
    }
}