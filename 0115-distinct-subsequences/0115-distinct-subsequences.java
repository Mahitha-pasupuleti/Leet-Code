class Solution {
    int[][] dp;
    private int noofDistinctWays(String s, String t, int n, int m) {
        if ( m < 0 ) return 1;
        if ( n < 0 ) return 0;
        if ( dp[n][m] != -1 ) return dp[n][m];
        int take = 0, notTake = 0;
        if ( s.charAt(n) == t.charAt(m) ) {
            take = noofDistinctWays(s, t, n-1, m-1); // (4, 0), babgba, ba
            notTake = noofDistinctWays(s, t, n-1, m); // (4, 1)
        } else {
            notTake = noofDistinctWays(s, t, n-1, m);
        }
        return dp[n][m] = take + notTake;
    }
    public int numDistinct(String s, String t) {
        int sLen = s.length(); 
        int tLen = t.length();
        dp = new int[sLen][tLen];
        for ( int i=0; i<sLen; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return noofDistinctWays(s, t, sLen - 1, tLen - 1); // 6, 2
    }
}