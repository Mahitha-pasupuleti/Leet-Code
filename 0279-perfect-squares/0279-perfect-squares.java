class Solution {
    int[] dp;
    private int solve(int n) {
        if ( n == 0 ) return 0;
        if ( n < 0 ) return Integer.MAX_VALUE;
        int root = (int)Math.sqrt(n);
        if ( dp[n] != -1 ) return dp[n];

        int minCount = Integer.MAX_VALUE;
        for ( int i=1; i*i<=n; i++ ) {
            int result = solve(n - i*i);
            if ( result != Integer.MAX_VALUE ) {
                minCount = Math.min(minCount, 1+result);
            }
        }
        
        return dp[n] = minCount;
    }
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
}