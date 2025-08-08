class Solution {
    int[] dp;
    private int solve(int n, int[] nums) {
        if ( n >= nums.length ) return 0;
        if ( dp[n] != -1 ) return dp[n];
        return dp[n] = Math.max(nums[n] + solve(n+2, nums), nums[n] + solve(n+3, nums));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return Math.max( solve(0, nums), solve(1, nums) );
    }
}