class MyStack {
    private Queue<Integer> first;
    private Queue<Integer> second;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    public void push(int x) {
        first.add(x); // add front
    }
    
    public int pop() {
        int popElement = 0;
        while ( !first.isEmpty() ) {
            popElement = first.poll(); // 2
            if ( !first.isEmpty() ) second.add( popElement );
        }
        while ( !second.isEmpty() ) {
            first.add( second.poll() );
        }
        return popElement;
    }
    
    public int top() {
        int popElement = 0;
        while ( !first.isEmpty() ) {
            popElement = first.poll(); // 2
            second.add( popElement );

        }
        while ( !second.isEmpty() ) {
            first.add( second.poll() );
        }
        return popElement;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */