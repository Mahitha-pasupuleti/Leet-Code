class Solution {
    int[][] dp;
    private int solve(int start, int prevColor, int[][] costs) {
        if ( start == costs.length ) return 0;
        if ( prevColor != -1 && dp[start][prevColor] != -1 ) return dp[start][prevColor];
        int red = Integer.MAX_VALUE, green = Integer.MAX_VALUE, blue = Integer.MAX_VALUE;

        if ( prevColor != 0 ) red = costs[start][0] + solve(start+1, 0, costs);
        if ( prevColor != 1 ) green = costs[start][1] + solve(start+1, 1, costs);
        if ( prevColor != 2 ) blue = costs[start][2] + solve(start+1, 2, costs);

        int minimum = Math.min(Math.min(red, green), blue);
        if ( prevColor == -1 ) return minimum;
        return dp[start][prevColor] = minimum;
    }
    public int minCost(int[][] costs) {
        int n = costs.length;
        dp = new int[n+1][4];
        for ( int i=0; i<=n; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, -1, costs); // start house index, previous house color
    }
}