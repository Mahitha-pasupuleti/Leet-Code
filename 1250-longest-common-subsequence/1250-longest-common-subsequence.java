class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];

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

        // for ( int i=1; i<=n; i++ ) {
        //     for ( int j=1; j<=m; j++ ) {
        //         System.out.print( dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // int i = n, j = m, len = dp[n][m];
        // StringBuilder result = new StringBuilder();
        // while ( len != 0 ) {
        //     if ( text1.charAt(i-1) == text2.charAt(j-1) ) {
        //         result.append(text1.charAt(i-1));
        //         len--;
        //         i--;
        //         j--;
        //     } else {
        //         if ( dp[i][j-1] > dp[i-1][j] ) {
        //             j--;
        //         } else {
        //             i--;
        //         }
        //     }
        // }

        // System.out.println( result.toString() );

        return dp[n][m];

        // return result.reverse().toString();
    }
}