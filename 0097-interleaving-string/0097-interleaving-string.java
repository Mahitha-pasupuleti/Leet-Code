class Solution {
    Boolean[][] dp;
    private boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        if ( i+j == s3.length() ) return i == s1.length() && j == s2.length();
        if ( dp[i][j] != null ) return dp[i][j];
        boolean s1Take = false;
        boolean s2Take = false;
        if ( i<s1.length() && s1.charAt(i) == s3.charAt(i+j) ) {
            s1Take = solve(i+1, j, i+j+1, s1, s2, s3);
        }
        if ( j<s2.length() && s2.charAt(j) == s3.charAt(i+j) ) {
            s2Take = solve(i, j+1, i+j+1, s1, s2, s3);
        }
        return dp[i][j] = s1Take || s2Take;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length() ) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(0, 0, 0, s1, s2, s3);
    }
}