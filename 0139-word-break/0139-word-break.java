class Solution {
    Boolean[] dp;
    private boolean solve(int start, String s, List<String> wordDict) {
        if ( start >= s.length() ) return true;
        if ( dp[start] != null ) return dp[start];
        for ( String word : wordDict ) {
            if ( start + word.length() > s.length() ) continue;
            String wordOfS = s.substring(start, start + word.length());
            if ( wordOfS.equals(word) ) {
                dp[start] = solve(start + word.length(), s, wordDict);
                if ( dp[start] ) return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return solve(0, s, wordDict);
    }
}