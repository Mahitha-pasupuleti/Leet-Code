class Solution {
    int[] dp;
    private int solve(int start, String s, Map<Character, List<String>> map) {
        if ( start == s.length() ) return 0;
        if ( dp[start] != -1 ) return dp[start];

        int result = 1 + solve(start+1, s, map); // skip character
        if ( map.containsKey(s.charAt(start)) ) {
            List<String> matches = map.get(s.charAt(start));
            for ( String match : matches ) {
                if ( s.startsWith(match, start) ) {
                    result = Math.min(result, solve(start + match.length(), s, map)); // choose the minim among all
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