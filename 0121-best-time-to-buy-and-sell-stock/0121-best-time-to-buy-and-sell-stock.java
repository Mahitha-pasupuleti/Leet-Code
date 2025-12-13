class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffix = new int[n];
        suffix[n-1] = prices[n-1];
        for ( int i=n-2; i>=0; i-- ) {
            suffix[i] = Math.max(suffix[i+1], prices[i]);
        }
        // [7,6,6,6,6,4]
        int maxVal = 0;
        for ( int i=0; i<n; i++ ) {
            maxVal = Math.max(maxVal, suffix[i] - prices[i]);
        }
        return maxVal;
    }
}