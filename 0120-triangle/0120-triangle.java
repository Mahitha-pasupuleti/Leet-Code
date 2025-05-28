class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for ( int j=0; j<n; j++ ) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for ( int i=n-2; i>=0; i-- ) { // rows from last
            for ( int j=0; j<=i; j++ ) {
                dp[i][j] = triangle.get(i).get(j) + Math.min( dp[i+1][j], dp[i+1][j+1] );
            }
        }

        return dp[0][0];
    }
}

/*
class Solution {
    public int solve( int start, int end, int n, List<List<Integer>> triangle, int[][] dp ) {
        if ( start >= n || end >= n ) return Integer.MAX_VALUE;
        if ( dp[start][end] != -1 ) return dp[start][end];
        if ( start == n-1 ) return 0;
        return dp[start][end] = Math.min( 
            triangle.get(start+1).get(end) + solve(start+1, end, n, triangle, dp), 
            triangle.get(start+1).get(end+1) + solve(start+1, end+1, n, triangle, dp) 
        );
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for ( int i=0; i<n; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return triangle.get(0).get(0) + solve(0, 0, n, triangle, dp);
    }
}
*/