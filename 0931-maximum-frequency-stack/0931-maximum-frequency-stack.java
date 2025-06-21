class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> freqStackMap;
    private int maxFrequency = 0;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
    }
    
    public void push(int val) {
        freqMap.put( val, freqMap.getOrDefault( val, 0 ) + 1 );

        int currFrequency = freqMap.get( val );
        Stack<Integer> stack;
        if ( freqStackMap.containsKey( currFrequency ) ) {
            stack = freqStackMap.get( currFrequency );
        } else {
            stack = new Stack<>();
        }
        stack.push( val );
        freqStackMap.put( currFrequency, stack );

        if ( currFrequency > maxFrequency ) maxFrequency = currFrequency;
    }
    
    public int pop() {
        Stack<Integer> stack = freqStackMap.get( maxFrequency );
        int valueToReturn = stack.pop();

        int freqValue = freqMap.get( valueToReturn );
        freqMap.put( valueToReturn, --freqValue );

        if ( stack.isEmpty() ) maxFrequency -= 1;
        return valueToReturn;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */