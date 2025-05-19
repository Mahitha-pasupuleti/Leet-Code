class Solution {
    int[] dp;
    public int solve(int[] nums, int i, int j) {
        if ( i >= j ) return 0;
        if ( dp[j] != -1 ) return dp[j];
        int pick = nums[j-1] + solve(nums, i, j-2); // if taken no adjacent
        int notPick = solve(nums, i, j-1); // else continue adjacent
        return dp[j] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 1 ) return nums[0];
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int first = solve(nums, 0, n-1); // with 0, you dont want to involve last value since they are adjacent
        Arrays.fill(dp, -1);
        int second = solve(nums, 1, n);
        return Math.max(first, second);
    }
}