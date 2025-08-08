class Solution {
    int[][] dp;
    private int solve(int start, int[] coins, int amount) {
        if ( start >= coins.length || amount<0 ) return Integer.MAX_VALUE;
        if ( dp[start][amount] != -1 ) return dp[start][amount];
        if ( amount == 0 ) return 0;

        int pick = solve(start, coins, amount - coins[start]);
        if ( pick != Integer.MAX_VALUE ) pick = 1 + pick; // ******u need to add 1 only when u pick something*******

        int notPick = solve(start+1, coins, amount);
        int result = Math.min(pick, notPick);

        return dp[start][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for ( int i=0; i<coins.length; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        int result = solve(0, coins, amount);
        if ( result == Integer.MAX_VALUE ) return -1;
        return result;
    }
}