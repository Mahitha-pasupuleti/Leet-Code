class SmallestInfiniteSet {
    private Integer minNum;
    private PriorityQueue<Integer> minHeap;
    public SmallestInfiniteSet() {
        minNum = 1;
        minHeap = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if ( !minHeap.isEmpty() ) {
            return minHeap.poll();
        }
        minNum++; // minHeap is empty
        return minNum - 1;
    }
    
    public void addBack(int num) {
        if ( minNum > num && !minHeap.contains(num) ) {
            minHeap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */