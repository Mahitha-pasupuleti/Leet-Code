class Solution {
    // Good naming convention
    private int findLongestCommonSubsequence(String text1, String text2, int n, int m, int[][] dp) {
        if ( n == 0 || m == 0 ) return 0;
        if ( dp[n][m] != -1 ) return dp[n][m];
        if ( text1.charAt(n-1) == text2.charAt(m-1) ) {
            return dp[n][m] = 1 + findLongestCommonSubsequence(text1, text2, n-1, m-1, dp);
        }
        return dp[n][m] = Math.max( findLongestCommonSubsequence(text1, text2, n-1, m, dp), findLongestCommonSubsequence(text1, text2, n, m-1, dp) );
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        // for ( int i=0; i<=text1_Len; i++ ) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return findLongestCommonSubsequence(text1, text2, n, m, dp);

        // if text1 is empty string then, for any length of text2, the result is 1
        //    "" a b c
        // ""  1.1 1 1
        for ( int i=0; i<=n; i++ ) {
            dp[i][0] = 0;
        }

        for ( int j=0; j<=m; j++ ) {
            dp[0][j] = 0;
        }

        for ( int i=1; i<=n; i++ ) {
            for ( int j=1; j<=m; j++ ) {
                if ( text1.charAt(i-1) == text2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        return dp[n][m];
    }
}