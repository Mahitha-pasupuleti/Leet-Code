class Solution {
    Boolean[] dp;
    public boolean solve(String s, List<String> wordDict, int i) {
        if ( i >= s.length() ) return true;
        if ( dp[i] != null ) return dp[i];
        for ( String word : wordDict ) {
            if ( i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word) ) {
                if ( solve( s, wordDict, i + word.length() ) ) {
                    return true;
                }
                dp[i] = false;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n+1];
        // Arrays.fill(dp, nu);
        return solve(s, wordDict, 0);
    }
}