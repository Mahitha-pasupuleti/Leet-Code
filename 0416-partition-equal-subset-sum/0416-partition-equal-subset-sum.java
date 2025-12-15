class Solution {
    Boolean[][] dp;
    private boolean solve(int start, int target, int[] nums) {
        if ( target == 0 ) return true;
        if ( target < 0 || start == nums.length ) return false;
        if ( dp[start][target] != null ) return dp[start][target];
        if ( nums[start] <= target ) {
            return dp[start][target] = solve(start+1, target-nums[start], nums) || solve(start+1, target, nums);
        } else {
            return dp[start][target] = solve(start+1, target, nums);
        }
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for ( int num : nums ) {
            sum += num;
        }
        if ( sum % 2 != 0 ) return false;

        dp = new Boolean[nums.length+1][(sum/2)+1];

        return solve(0, sum/2, nums);
    }
}

// find subset with sum/2