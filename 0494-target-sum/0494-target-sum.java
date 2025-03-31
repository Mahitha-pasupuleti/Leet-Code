class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for ( int i=0; i<n; i++ ) sum += nums[i];

        if ( (target + sum)%2 != 0 ) return 0;
        
        int newTarget = (target + sum)/2;
        if ( newTarget < 0 ) newTarget -= target;
        // System.out.println(newTarget);

        int[][] dp = new int[n+1][newTarget+1];
        dp[0][0] = 1;

        for ( int i=1; i<=n; i++ ) {
            for ( int j=0; j<=newTarget; j++ ) {
                dp[i][j] = dp[i-1][j];
                if ( nums[i-1] <= j ) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][newTarget];
    }
}