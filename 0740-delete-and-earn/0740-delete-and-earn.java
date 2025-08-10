class Solution {
    int[] dp;
    private int solve(int start, int[] nums) {
        if ( start >= nums.length ) return 0;
        if ( dp[start] != -1 ) return dp[start];

        // if adjacent equal add points and skip them;
        int i = start+1;
        int val = nums[start];
        int earnedPoints = nums[start];
        
        while ( i < nums.length && nums[i] == val ) {
            earnedPoints += val;
            i++;
        }

        while ( i < nums.length && nums[i]-val == 1 ) {
            i++;
        }

        int take = earnedPoints + solve(i, nums);
        int notTake = solve(start+1, nums);

        return dp[start] = Math.max(take, notTake);
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return solve(0, nums);
    }
}