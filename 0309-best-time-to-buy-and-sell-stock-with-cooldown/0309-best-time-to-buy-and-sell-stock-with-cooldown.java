class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int buy = -prices[0];
        int sell = 0;
        int cool = 0;
        
        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            
            buy = Math.max(buy, cool - prices[i]);
            sell = prevBuy + prices[i];
            cool = Math.max(cool, prevSell);
        }
        
        return Math.max(sell, cool);
    }
}
