class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int[] newEntry = new int[2];
        newEntry[0] = price;
        newEntry[1] = 1;
        while ( !stack.isEmpty() && stack.peek()[0] <= price ) {
            newEntry[1] += stack.peek()[1];
            stack.pop();
        }
        stack.push(newEntry);

        return newEntry[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */