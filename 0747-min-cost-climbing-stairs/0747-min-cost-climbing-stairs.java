class Solution {
    int[] dp;
    public int solve(int[] cost, int n) {
        if ( n >= cost.length ) return 0;
        if ( dp[n] != -1 ) return dp[n];
        return dp[n] = cost[n] + Math.min( solve(cost, n+1), solve(cost, n+2) );
    }
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        dp = new int[size + 1];
        for ( int i=0; i<size+1; i++ ) {
            dp[i] = -1;
        }
        return Math.min( solve(cost, 0), solve(cost, 1) );
    }
}