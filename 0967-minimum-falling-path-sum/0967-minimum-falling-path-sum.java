class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for ( int j=0; j<n; j++ ) {
            dp[n-1][j] = matrix[n-1][j];
        }
        for ( int i=n-2; i>=0; i-- ) { // row
            for ( int j=0; j<n; j++ ) {
                int minVal = Integer.MAX_VALUE;
                for ( int k=j-1; k<=j+1; k++ ) {
                    if ( k >= 0 && k < n ) minVal = Math.min( minVal, dp[i+1][k] ); // next row
                }
                dp[i][j] = matrix[i][j] + minVal;
            }
        }
        int result = Integer.MAX_VALUE;
        for ( int i=0; i<n; i++ ) result = Math.min( result, dp[0][i] );

        return result;
    }
}

// class Solution {
//     public int solve(int x, int y, int n, int[][] matrix, int[][] dp ) {
//         if ( x < 0 || y < 0 || x >= n || y >= n) return Integer.MAX_VALUE; // invalid path
//         if ( x == n-1 ) return matrix[x][y]; // base condition

//         if ( dp[x][y] != Integer.MAX_VALUE ) return dp[x][y];
        
//         int minVal = Integer.MAX_VALUE;
//         for ( int i = y-1; i<= y+1; i++ ) {
//             minVal = Math.min( minVal, solve(x+1, i, n, matrix, dp) );
//         }
//         return dp[x][y] = matrix[x][y] + minVal;
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int minVal = Integer.MAX_VALUE;
//         int[][] dp = new int[n][n];
//         for ( int i=0; i<n; i++ ) {
//             Arrays.fill(dp[i], Integer.MAX_VALUE);
//         }
//         for ( int i=0; i<n; i++ ) {
//             minVal = Math.min( minVal, solve(0, i, n, matrix, dp) );
//         }
//         return minVal;
//     }
// }