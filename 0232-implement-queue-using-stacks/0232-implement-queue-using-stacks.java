class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        int popElement = 0;
        while ( !first.isEmpty() ) {
            popElement = first.pop();
            if ( !first.isEmpty() ) second.push( popElement );
        }
        while ( !second.isEmpty() ) {
            first.push( second.pop() );
        }
        return popElement;
    }
    
    public int peek() {
        int popElement = 0;
        while ( !first.isEmpty() ) {
            popElement = first.pop();
            second.push( popElement );
        }
        while ( !second.isEmpty() ) {
            first.push( second.pop() );
        }
        return popElement;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */