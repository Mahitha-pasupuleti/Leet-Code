class Solution {
    int[][] dp;
    public int solve(int[] squares, int i, int target) {
        // till target becomes 0
        if ( i < 0 ) return Integer.MAX_VALUE; // some maximum value
        if ( dp[i][target] != -1 ) return dp[i][target];
        if ( target == 0 ) return 0;

        int take = Integer.MAX_VALUE;
        if ( squares[i] <= target ) {
            int result = solve(squares, i, target-squares[i]); // TAKE: the outcome could be 0 or MAX_VALUE, because those are only values being returned
            if ( result != Integer.MAX_VALUE ) take = 1 + result; // got a combination whose sum == target
        }
        
        int noTake = solve(squares, i-1, target); //NOTAKE: the outcome could be 0 or MAX_VALUE, because those are only values being returned
        return dp[i][target] = Math.min(take, noTake);
    }
    public int numSquares(int n) {
        // Create new array with all perfect sqaure
        int noOfPerfectSqaures = 0;
        for ( int i=1; i*i <= n; i++ ) {
            // System.out.println(noOfPerfectSqaures+1);
            noOfPerfectSqaures++;
        }

        int[] squares = new int[noOfPerfectSqaures];
        int index = 0;
        for ( int i=1; i*i <= n; i++ ) {
            squares[index++] = i*i;
        }

        dp = new int[noOfPerfectSqaures+1][n+1];
        for ( int i=0; i<noOfPerfectSqaures; i++ ) {
            for ( int j=0; j<n+1; j++ ) {
                dp[i][j] = -1;
            }
        }

        return solve(squares, noOfPerfectSqaures-1, n); // n-1
    }
}

/*

12 : [1, 4, 9] : find least length sum combination of given array
 - 

*/