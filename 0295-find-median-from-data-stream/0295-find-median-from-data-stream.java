class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );
    }
    
    public void addNum(int num) {

        // maxheap empty add
        // maxheap peek is larger add
        // if num is in b/w both top ele add
        // add to minheap only if added value is striclty larger then peek

        if ( !minHeap.isEmpty() && minHeap.peek() < num ) minHeap.add(num);
        else maxHeap.add(num);

        if ( maxHeap.size() - minHeap.size() == 2 ) {
            minHeap.add(maxHeap.poll()); // balancing
        } else if ( minHeap.size() - maxHeap.size() == 2 ) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if ( maxHeap.size() > minHeap.size() ) return maxHeap.peek();
        if ( maxHeap.size() < minHeap.size() ) return minHeap.peek();

        return (double)( maxHeap.peek() + minHeap.peek() ) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */