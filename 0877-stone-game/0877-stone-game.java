class Solution {
    Boolean[][] dp;
    private boolean game(int start, int end, int aHas, int bHas, char player, int[] piles) {
        if ( dp[start][end] != null ) return dp[start][end];
        if ( start == end ) {
            if ( aHas > bHas ) return true;
            return false;
        }
        boolean takeFirst = false, takeLast = false;
        if ( player == 'A' ) {
            takeFirst = game(start+1, end, aHas + piles[start], bHas, 'B', piles);
            takeLast = game(start, end-1, aHas + piles[end], bHas, 'B', piles);
        } else if ( player == 'B' ) {
            takeFirst = game(start+1, end, aHas, bHas + piles[start], 'A', piles);
            takeLast = game(start, end-1, aHas, bHas + piles[end], 'A', piles);
        }

        return dp[start][end] = takeFirst || takeLast;
    }
    public boolean stoneGame(int[] piles) {
        dp = new Boolean[piles.length+1][piles.length+1];
        return game(0, piles.length-1, 0, 0, 'A', piles);
    }
}