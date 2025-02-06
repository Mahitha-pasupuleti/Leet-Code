class Solution {
    public int lastStoneWeight(int[] stones) {
        // minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while ( pq.size() > 1 ) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add( first - second );
        }

        if ( pq.size() == 1 ) return pq.poll();
        
        return 0;
    }
}