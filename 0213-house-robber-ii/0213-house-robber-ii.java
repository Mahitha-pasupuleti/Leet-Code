class Solution {
    public int solve(int[] nums, int i, int j, int[] dp) {
        if ( i > j ) return 0;
        if ( dp[i] != -1 ) return dp[i];
        return dp[i] = Math.max( nums[i] + solve(nums, i+2, j, dp) , solve(nums, i+1, j, dp) );
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        Arrays.fill(dp0, -1);
        Arrays.fill(dp1, -1);

        return Math.max(solve(nums, 0, n-2, dp0) , solve(nums, 1, n-1, dp1));
    }
}