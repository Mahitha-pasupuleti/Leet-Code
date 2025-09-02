class Solution {
    Map<String, Boolean> memo;
    private boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        if ( k == s3.length() ) return i==s1.length() && j==s2.length();
        String key = i + ":" + j + ":" + k;
        if ( memo.containsKey(key) ) return memo.get(key);
        boolean s1Take = false;
        boolean s2Take = false;
        if ( i<s1.length() && k<s3.length() && s1.charAt(i) == s3.charAt(k) ) {
            s1Take = solve(i+1, j, k+1, s1, s2, s3);
        }
        if ( j<s2.length() && k<s3.length() && s2.charAt(j) == s3.charAt(k) ) {
            s2Take = solve(i, j+1, k+1, s1, s2, s3);
        }
        boolean value = s1Take || s2Take;
        memo.put(key, value);
        return value;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length() ) return false;
        memo = new HashMap<>();
        return solve(0, 0, 0, s1, s2, s3);
    }
}