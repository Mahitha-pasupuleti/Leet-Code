class Solution {
    public int minDistance(String word1, String word2) {
        // Find common between both strings and find count of remaining characters in both strings they need to be deleted
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for ( int i=0; i<n+1; i++ ) {
            for ( int j=0; j<m+1; j++ ) {
                if ( i==0 || j==0 ) dp[i][j] = 0;
                else if ( word1.charAt(i-1) == word2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        // StringBuilder str = new StringBuilder();
        
        // int i=n, j=m;

        // while ( i>0 && j>0 ) {
        //     if ( s1.charAt(i-1) == s2.charAt)
        // }

        return (n - dp[n][m]) + (m - dp[n][m]);
    }
}