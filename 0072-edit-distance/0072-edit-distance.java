class Solution {
    int[][] dp;
    private int solve(String word1, String word2, int n, int m) {
        if ( n == 0 ) return m;
        if ( m == 0 ) return n;
        if ( word1.charAt(n-1) == word2.charAt(m-1) ) {
            return solve(word1, word2, n-1, m-1);
        } else {
            int insert = 1 + solve(word1, word2, n, m-1); // insert
            int delete = 1 + solve(word1, word2, n-1, m);
            int replace = 1 + solve(word1, word2, n-1, m-1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        
        return solve(word1, word2, word1.length(), word2.length());
    }
}