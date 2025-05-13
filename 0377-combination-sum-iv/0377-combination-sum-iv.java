class Solution {
    int[] dp;
    public int solve(int[] nums, int target) {
        if ( dp[target] != -1 ) return dp[target]; 
        if ( target == 0 ) return 1;
        int result = 0;
        for ( int i=0; i<nums.length; i++ ) {
            if ( target >= nums[i] ) {
                result += solve(nums, target-nums[i]);
            }
        }
        dp[target] = result;
        return result;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return solve(nums, target);
    }
}