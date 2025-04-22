class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for ( int stone : stones ) {
            maxHeap.add(stone);
        }

        while ( maxHeap.size() > 1 ) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if ( first - second > 0 ) maxHeap.add(first - second);
        }

        if ( maxHeap.size() == 1 ) return maxHeap.poll();

        return 0;
    }
}