class Solution {
    int[] dp;
    public int solve(int[] nums, int i) {
        if ( i >= nums.length ) return 0;
        if ( dp[i] != -1 ) return dp[i];
        return dp[i] = Math.max( nums[i] + solve(nums, i+2), solve(nums, i+1) ); 
        // 0/1 Kanpsack problem
    }
    public int rob(int[] nums) {
        int n= nums.length;
        dp = new int[n+1];
        for ( int i=0; i<n+1; i++ ) dp[i] = -1;
        return solve(nums, 0);
    }
}