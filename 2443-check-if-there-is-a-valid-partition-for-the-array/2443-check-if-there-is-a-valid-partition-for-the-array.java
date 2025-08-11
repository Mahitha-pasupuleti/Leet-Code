class Solution {
    Boolean[] dp;
    private boolean checkEqual(int[] nums, int start, int end) {
        int val = nums[start];
        start++;
        while ( start <= end ) {
            if ( nums[start] != val ) return false;
            start++;
        }
        return true;
    }
    private boolean isIncreasing(int[] nums, int start, int end) {
        while ( start < end ) {
            if ( nums[start+1] - nums[start] != 1 ) return false;
            start++;
        }
        return true;
    }
    private boolean solve(int start, int[] nums) {
        if ( start == nums.length ) return true;
        if ( dp[start] != null ) return dp[start];
        boolean result1 = false, result2 = false;
        if ( start+1 < nums.length && checkEqual(nums, start, start+1) ) result1 = solve(start+2, nums);
        if ( start+2 < nums.length && (checkEqual(nums, start, start+2) || isIncreasing(nums, start, start+2)) ) result2 = solve(start+3, nums);
        return dp[start] = result1 || result2;
    }
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length+1];
        return solve(0, nums);
    }
}