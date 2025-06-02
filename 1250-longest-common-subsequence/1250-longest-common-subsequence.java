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
        int text1_Len = text1.length();
        int text2_Len = text2.length();
        int[][] dp = new int[text1_Len + 1][text2_Len + 2];
        for ( int i=0; i<=text1_Len; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return findLongestCommonSubsequence(text1, text2, text1_Len, text2_Len, dp);
    }
}