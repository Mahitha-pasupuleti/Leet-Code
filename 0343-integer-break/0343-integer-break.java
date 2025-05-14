class Solution {
    int[][] dp;
    public int solve(int i, int target) {
        if ( i <= 0 ) return Integer.MIN_VALUE;
        if ( dp[i][target] != -1 ) return dp[i][target];
        if ( target == 0 ) return 1; // [1, 0] = 1, [1, 0] = 1

        int take = Integer.MIN_VALUE;
        if ( i <= target ) { // [9, 10], [1, 1] [1, 2]
            int result = solve(i, target-i); // [9, 1], [1, 0] = 1, [1, 1], [1, 0] = 1
            // either 1(1+ -> product) or MAX will be returned, if product or 1 returned the target value is being reached
            // if MAX, there is no possible comination this end
            if ( result != Integer.MIN_VALUE ) take = i * result; // [1, 0] = 1*1, [9, 10] = 9*1 // [1, 0] = 1*1
        }
        int noTake = solve(i-1, target); // [8, 1]=1, [7, 1]=1, [6, 1]=1, [5, 1]=1, [4, 1]=1, [3, 1]=1, [2, 1]=1
        return dp[i][target] = Math.max(take, noTake); // 9
    }
    public int integerBreak(int n) {
        // from 1 to n
        dp = new int[n][n+1];
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n+1; j++ ) {
                dp[i][j] = -1;
            }
        }

        return solve(n-1, n); // [9, 10] [1, 2]
    }
}

/*

 - from 1 to n, find comination of integers(repitition allowed) to get sum as n
 - while product be minimized
 - take or not take policy
 - 0(not allowed), 2 not allowed
 - the k >= 2, so single value not allowed

*/