class MedianFinder {
    /* 
     Use priority queue

    */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>( (a, b) -> (b-a) );
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num); // [0,2,5,6], [6,10]
        minHeap.add(maxHeap.poll()); // [0,2,5], [6,6,10]
        if ( minHeap.size() > maxHeap.size() ) {
            maxHeap.add(minHeap.poll()); // [2,5,6], [6,10]
        }
    }
    
    public double findMedian() {
        if ( maxHeap.size() > minHeap.size() ) {
            return (double) maxHeap.peek();
        } else {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */