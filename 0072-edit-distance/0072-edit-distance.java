class Solution {
    private int getMinDistance(String word1, String word2, int n, int m, int[][] dp) {
        // if word1 is exhausted
        if ( n <= 0 ) return m;
        if ( m <= 0 ) return n;
        if ( dp[n][m] != -1 ) return dp[n][m];

        if ( word1.charAt(n-1) == word2.charAt(m-1) ) {
            return dp[n][m] = getMinDistance(word1, word2, n-1, m-1, dp);
        } else {
            int insert = 1 + getMinDistance(word1, word2, n, m-1, dp);
            int delete = 1 + getMinDistance(word1, word2, n-1, m, dp);
            int replace = 1 + getMinDistance(word1, word2, n-1, m-1, dp);
            int minVal = 0;
            if ( insert < delete ) {
                if ( insert < replace ) minVal = insert;
                else minVal = replace;
            } else {
                if ( delete < replace ) minVal = delete;
                else minVal = replace;
            }
            return dp[n][m] = minVal;
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];
        for ( int i=0; i<=n; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        
        return getMinDistance(word1, word2, n, m, dp);
    }
}