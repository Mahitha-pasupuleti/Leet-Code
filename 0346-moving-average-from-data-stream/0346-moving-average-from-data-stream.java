class MovingAverage {

    private Deque<Integer> dq;
    private int windowSize;
    private double currentSum = 0;

    public MovingAverage(int size) {
        this.dq = new ArrayDeque<>();
        this.windowSize = size;
    }
    
    public double next(int val) {
        dq.addLast(val);
        if ( dq.size() <= windowSize ) {
            currentSum += val;
            return currentSum/dq.size();
        } else {
            currentSum -= dq.pollFirst();
            currentSum += val;
            return currentSum/windowSize;
        }
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */