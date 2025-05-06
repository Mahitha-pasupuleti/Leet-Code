class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // Find the LCS of str1 and str2 and add them to a string result
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for ( int i=0; i<n+1; i++ ) dp[i][0] = 0;
        for ( int j=0; j<m+1; j++ ) dp[0][j] = 0;

        for ( int i=1; i<n+1; i++ ) {
            for ( int j=1; j<m+1; j++ ) {
                if ( str1.charAt(i-1) == str2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        // int lcsLength = dp[n][m];
        StringBuilder LCS_STR = new StringBuilder();

        int i=n, j=m;
        while ( i>0 && j>0 ) {
            if ( str1.charAt(i-1) == str2.charAt(j-1) ) {
                LCS_STR.append( str1.charAt(i-1) );
                i--;
                j--;
            } else {
                if ( dp[i-1][j] > dp[i][j-1] ) {
                    LCS_STR.append( str1.charAt(i-1) );
                    i--;
                }
                else{
                    LCS_STR.append( str2.charAt(j-1) );
                    j--;
                } 
            }
        }

        while ( i > 0 ) {
            LCS_STR.append( str1.charAt(i-1) );
            i--;
        }

        while ( j > 0 ) {
            LCS_STR.append( str2.charAt(j-1) );
            j--;
        }

        LCS_STR.reverse();

        // StringBuilder MAIN_STR = new StringBuilder();
        // MAIN_STR.append(str1);
        // MAIN_STR.append(str2);

        // System.out.println(LCS_STR);
        // System.out.println(MAIN_STR);

        // Append all characters before LCS string from str1 + str2, add the LCS string, 
        // then add all the characters after the LCS string from str1 + str2

        return LCS_STR.toString();
    }
}