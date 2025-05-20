class Solution {
    int[] dp;
    public int solve(String s, int i) {
        if ( i >= s.length() ) return 1;
        if ( dp[i] != -1 ) return dp[i];

        int x=0, y=0;

        int curr1Digit = s.charAt(i) - '0'; // automatically between 0 - 9
        if ( curr1Digit == 0 ) return 0;
        x += solve(s, i+1);

        if ( i+1 < s.length() ) { // valid substring exists
            int curr2Digits = Integer.parseInt(s.substring(i, i + 2));
            if ( curr2Digits <= 26 ) y += solve(s, i+2); // need to check explicity if b/w 10 to 26
        }

        return dp[i] = x + y;
    }
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
}

/*
    - in how many ways can u divide the string so it remains valid
    - u either divide into 1 or 2
    - if the value is 0 or starts with 0, discard it we dontr need it 
*/