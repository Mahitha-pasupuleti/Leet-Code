class MyHashSet {
    List<Integer> myList;
    public MyHashSet() {
        myList = new ArrayList();
    }
    
    public void add(int key) {
        if ( !myList.contains(key) ) myList.add(key);
    }
    
    public void remove(int key) {
        if ( myList.contains(key) ) myList.remove((Integer)key);
    }
    
    public boolean contains(int key) {
        return myList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */