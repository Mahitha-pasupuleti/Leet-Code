class MinStack {
    int minVal = Integer.MAX_VALUE;
    Stack<Integer> stack;
    List<Integer> list; 
    // to store the smallest value till the current value is entered
    // if the top value is removed, the list also should remove the last value
    // the top minValue till that point will be stored

    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // if last added element is greater than the curret element add current element
        // else add previous element again since i.e is the smallest element till then
        if ( list.size() == 0 ) list.add(val);
        else {
            if ( list.get( list.size()-1 ) < val ) { 
                list.add( list.get(list.size()-1) );
            } else {
                list.add(val);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        list.remove( list.size()-1 );
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return list.get( list.size()-1 );
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */