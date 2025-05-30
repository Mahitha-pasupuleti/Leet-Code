class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, n = stones.length;

        for ( int i=0; i<n; i++ ) sum += stones[i];
        int target = sum/2;

        Boolean[][] dp = new Boolean[n+1][target+1];

        for ( int k=target; k>=0; k-- ) {
            if ( isTargetPossible(stones, n, k, dp) ) {
                return (sum - 2*k);
            }
        }
        return -1;
    }
    public boolean isTargetPossible(int[] stones, int n, int target, Boolean[][] dp) {
        if ( target == 0 ) return true;
        if ( target < 0 || n <= 0 ) return false;
        if ( dp[n][target] != null ) return dp[n][target];
        if ( stones[n-1] <= target ) {
            return dp[n][target] = isTargetPossible(stones, n-1, target-stones[n-1], dp) || isTargetPossible(stones, n-1, target, dp);
        }
        return dp[n][target] = isTargetPossible(stones, n-1, target, dp);
    }
}