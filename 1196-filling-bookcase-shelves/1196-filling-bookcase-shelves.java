class Solution {
    int[] dp;
    private int solve(int start, int[][] books, int shelfWidth) {
        if ( start == books.length ) return 0;
        if ( dp[start] != -1 ) return dp[start];

        int currWidth = 0;
        int maxHeight = 0;
        int minShelfHeight = Integer.MAX_VALUE;

        for ( int i=start; i<books.length; i++ ) {
            currWidth += books[i][0];
            if ( currWidth > shelfWidth ) break;
            
            maxHeight = Math.max(maxHeight, books[i][1]);
            int totalHeight = maxHeight + solve(i+1, books, shelfWidth);
            minShelfHeight = Math.min(minShelfHeight, totalHeight);
        }
        return dp[start] = minShelfHeight;
    } 
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, books, shelfWidth);
    }
}