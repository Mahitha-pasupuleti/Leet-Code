class Solution {
    int[][] dp;
    private int solve( int start, int prev, int[] nums ) {
        if ( start == nums.length ) return 0;
        if ( dp[start][prev+1] != -1 ) return dp[start][prev+1];
        int take = 0 , notTake = 0;
        if ( prev == -1 || nums[start] > nums[prev] ) { // current value greater than prev value or first index value
            take = 1 + solve(start+1, start, nums);
        }
        notTake = solve(start+1, prev, nums);
        return dp[start][prev+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for ( int i=0; i<=n; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, -1, nums);
    }
}