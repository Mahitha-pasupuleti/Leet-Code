class Solution {
    int[] dp;
    private int solve(int n, int[] nums) {
        if ( n >= nums.length ) return 0;
        if ( dp[n] != -1 ) return dp[n];
        int pick = nums[n] + solve(n+2, nums);
        int notPick = solve(n+1, nums);
        return dp[n] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(0, nums);
    }
}