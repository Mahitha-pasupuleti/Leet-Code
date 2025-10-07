class Solution {
    int[] dp;
    private int solve(int start, String s, Map<Character, List<String>> map) {
        if ( start == s.length() ) return 0;
        if ( dp[start] != -1 ) return dp[start];

        int result = 1 + solve(start+1, s, map);
        if ( map.containsKey(s.charAt(start)) ) {
            List<String> matches = map.get(s.charAt(start));
            for ( String match : matches ) {
                if ( s.startsWith(match, start) ) {
                    result = Math.min(result, solve(start + match.length(), s, map));
                }
            }
        }
        return dp[start] = result;
    }
    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        Map<Character, List<String>> map = new HashMap<>();
        for ( String dict : dictionary ) {
            map.computeIfAbsent(dict.charAt(0), k -> new ArrayList<>()).add(dict);
        }
        return solve(0, s, map);
    }
}


/*
boolean isMatch = false;
            for ( String match : matches ) {
                int count = 0;
                for ( int i=0; i<match.length(); i++ ) {
                    if ( s.charAt(start+i) != match.charAt(i) ) break;
                    count++;
                }
                if ( count == match.length() ) {
                    isMatch = true;
                    result = solve(start+match.length(), s, map);
                }
            }
            if ( !isMatch ) result = 1 + solve(start+1, s, map);
*/