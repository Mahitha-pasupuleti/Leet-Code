class Solution {
    int[] dp;
    private int solve(int start, int[] days, int[] costs) {
        if ( start >= days.length ) return 0;
        if ( dp[start] != -1 ) return dp[start];
        // day pass
        int dayPass = costs[0] + solve(start+1, days, costs);
        // week pass
        int weekPass = costs[1];
        for ( int i=start+1; i<days.length; i++ ) {
            if ( days[i] > days[start]+6 ) {
                weekPass += solve(i, days, costs);
                break;
            }
        }
        // month pass
        int monthPass = costs[2];
        for ( int i=start+1; i<days.length; i++ ) {
            if ( days[i] > days[start]+29 ) {
                monthPass += solve(i, days, costs);
                break;
            }
        }
        return dp[start] = Math.min(dayPass, Math.min(weekPass, monthPass));
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length+1];
        Arrays.fill(dp, -1);
        return solve(0, days, costs);
    }
}