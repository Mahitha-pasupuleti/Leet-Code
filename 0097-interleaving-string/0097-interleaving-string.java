class Solution {
    Map<String, Boolean> memo;
    private boolean solve(int s1Index, int s2Index, int s3Index, String s1, String s2, String s3) {
        if ( s3Index == s3.length() && s1Index == s1.length() && s2Index == s2.length() ) return true;

        String key = s1Index + ":" + s2Index + ":" + s3Index;
        if ( memo.containsKey(key) ) return memo.get(key);

        if ( s1Index < s1.length() && s3Index < s3.length() && s3.charAt(s3Index) == s1.charAt(s1Index) ) {
            if ( solve(s1Index+1, s2Index, s3Index+1, s1, s2, s3) ) {
                memo.put(key, true);
                return true;
            }
        }
        if ( s2Index < s2.length() && s3Index < s3.length() && s3.charAt(s3Index) == s2.charAt(s2Index) ) {
            if ( solve(s1Index, s2Index+1, s3Index+1, s1, s2, s3) ) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new HashMap<>();
        return solve(0, 0, 0, s1, s2, s3);
    }
}