class Solution {
    int[][] dp;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private int increasingPath(int[][] matrix, int x, int y) {
        if ( dp[x][y] != -1 ) return dp[x][y];
        int result = 1;
        int maxResult = 1;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=matrix.length || dy >= matrix[0].length ) continue;
            if ( matrix[dx][dy] > matrix[x][y] ) {
                result = 1 + increasingPath(matrix, dx, dy);
                maxResult = Math.max(maxResult, result);
            }
        }
        return dp[x][y] = maxResult;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int largestPath = Integer.MIN_VALUE;
        dp = new int[m][n];
        for ( int i=0; i<m; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                largestPath = Math.max(largestPath, increasingPath(matrix, i, j));
            }
        }
        return largestPath;
    }
}