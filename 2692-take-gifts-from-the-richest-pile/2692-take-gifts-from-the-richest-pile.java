class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a, b) -> (b-a) );
        for ( int gift : gifts ) {
            maxHeap.add(gift);
        }

        while ( k-- != 0 ) {
            int top = maxHeap.poll();
            maxHeap.add( (int)Math.floor(Math.sqrt(top)) );
        }

        long sum = 0;
        while ( maxHeap.size() > 0 ) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}