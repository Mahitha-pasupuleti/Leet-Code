class CustomStack {

    int maxSize;
    List<Integer> list;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.list = new ArrayList<>();
    }
    
    public void push(int x) {
        if ( list.size() < maxSize ) {
            list.add(x);
        }
    }
    
    public int pop() {
        if ( list.size() == 0 ) return -1;
        return list.remove(list.size()-1);
    }
    
    public void increment(int k, int val) {
        for ( int i=0; i<k; i++ ) {
            if ( i >= list.size() ) break;
            list.set(i, val + list.get(i));
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */