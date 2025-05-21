class Solution {
    // minimize the sum along the path
    // move down or right
    // start at [0, 0], end at [m-1, n-1]
    public int solve(int[][] grid, int m, int n, int[][] dp) {

        if ( m <= 0 || n <= 0 ) return Integer.MAX_VALUE; // invalid case
        if ( dp[m][n] != -1 ) return dp[m][n];
        if ( m == 1 && n == 1 ) return grid[m-1][n-1]; // condtion satisfied

        int left = solve(grid, m-1, n, dp);
        int top = solve(grid, m, n-1, dp);

        return dp[m][n] = grid[m-1][n-1] + Math.min(top, left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];
        for ( int i=0; i<m+1; i++ ) {
            Arrays.fill(dp[i], -1);
        }

        return solve(grid, m, n, dp);
    }
}