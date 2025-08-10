class Solution {
    // find a subarray with sum/2
    // corner cases
    // [1]
    Boolean[][] dp;
    private boolean solve(int start, int[] nums, int amount) {
        if ( amount == 0 ) return true;
        if ( start == nums.length ) return false;

        if ( dp[start][amount] != null ) return dp[start][amount];

        if ( nums[start] <= amount ) {
            return dp[start][amount] = solve(start+1, nums, amount-nums[start]) || solve(start+1, nums, amount);
        } else {
            return dp[start][amount] = solve(start+1, nums, amount);
        }
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for ( int num : nums ) sum += num;
        // if sum is odd in first place, then there is no partion present
        if ( sum % 2 != 0 ) return false;

        dp = new Boolean[nums.length + 1][sum/2 + 1];

        // find subarray with given sum
        return solve(0, nums, sum/2);
    }
}