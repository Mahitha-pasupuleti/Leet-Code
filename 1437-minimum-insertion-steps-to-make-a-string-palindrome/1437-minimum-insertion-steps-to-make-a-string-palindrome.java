class Solution {
    public int minInsertions(String s1) {
        /* 
        - Find the longest palindrome subsequence of the given string
        - This can be done by below steps
          - Perform LCS between s1(main string) and s2(reversed string)
          - The result is the length of the Longest Palindrome Subsequence
        - Finally length of original String - length of Longest Palindrome Subsequence is our answer
        */

        StringBuilder str = new StringBuilder(s1);
        String s2 = str.reverse().toString();

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

        return n - dp[n][m];
    }
}