class Solution {
    int[] dp;
    private int solve(int index, int end, int[] nums) {
        if ( index >= end ) return 0;
        if ( dp[index] != -1 ) return dp[index];
        int pick = nums[index] + solve(index+2, end, nums);
        int notPick = solve(index+1, end, nums);
        return dp[index] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        if ( nums.length == 1 ) return nums[0];
        int n = nums.length;
        dp = new int[n+1];

        Arrays.fill(dp, -1);
        int first = solve(0, n-1, nums);

        Arrays.fill(dp, -1);
        int second = solve(1, n, nums);

        return Math.max( first, second );
    }
}