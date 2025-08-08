class Solution {
    int[] dp;
    private int solve(int start, int end, int[] nums ) {
        if ( start >= end ) return 0;
        if ( dp[start] != -1 ) return dp[start];
        int pick = nums[start] + solve(start+2, end, nums); // picked first house
        int notPick = solve(start+1, end, nums); // not picked first house
        return dp[start] = Math.max( pick, notPick );
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 1 ) return nums[0];
        dp = new int[n+1];

        Arrays.fill(dp, -1);
        int withZero = solve(0, n-1, nums);

        Arrays.fill(dp, -1);
        int withoutZero = solve(1, n, nums);
        return Math.max( withZero, withoutZero );
    }
}