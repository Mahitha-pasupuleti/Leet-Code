class Solution {
    public long pickGifts(int[] gifts, int k) {
        /* */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for ( int i=0; i<gifts.length; i++ ) {
            pq.add(gifts[i]);
        }
        while ( k!=0 ) {
            int max = pq.poll();
            pq.add((int)Math.floor(Math.sqrt(max)));
            k--;
        }
        long sum = 0;
        while ( !pq.isEmpty() ) {
            sum += pq.poll();
        }
        return sum;
    }
}