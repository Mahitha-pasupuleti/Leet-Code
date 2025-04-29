class Solution {
    public int maxProfit(int[] prices) {
        int i=0, j=1, result=0;
        while ( j < prices.length ) {
            int stockPrice = prices[j] - prices[j-1];
            if ( stockPrice < 0 ) {
                result += ( prices[j-1] - prices[i] );
                i=j;
            }
            j++;
        }
        if (prices[prices.length - 1] > prices[i]) {
            result += prices[prices.length - 1] - prices[i];
        }
        return result;
    }
}