class Solution {
    public int longestPalindromeSubseq(String s1) {
        // This a type of pattern of LCS
        // The difference is we do not have a second string
        // The trick is reverse the first string and perform LCS on both strings 
        // in order to get the longest palindrome

        // So basically, if u reverse a string and perform LCS with the mainString and reversed string, 
        // you will get your longest palindrome subsequence

        StringBuilder s = new StringBuilder(s1);
        String s2 = s.reverse().toString();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for ( int i=0; i<n+1; i++ ) {
            for ( int j=0; j<m+1; j++ ) {
                if ( i==0 || j==0 ) dp[i][j] = 0;
                else if ( s1.charAt(i-1) == s2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        return dp[n][m];

    }
}