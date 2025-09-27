class Solution {
    int[] dp;
    private int solve(int i, int n, int[] costs) {
        if ( i > n ) return Integer.MAX_VALUE;
        if ( i == n ) return 0;
        if ( dp[i] != -1 ) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for ( int jump=1; jump<=3; jump++ ) {
            int next = i + jump;
            int cost = Integer.MAX_VALUE;
            if ( next <= n ) {
                cost = costs[next-1] + (jump * jump);
                int value = solve(next, n, costs);
                if ( value != Integer.MAX_VALUE ) minCost = Math.min(minCost, cost + value);
            }
        }
        
        return dp[i] = minCost;
    }
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs);
    }
}