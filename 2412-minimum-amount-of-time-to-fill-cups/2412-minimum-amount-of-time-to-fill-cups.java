class Solution {
    public int fillCups(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> (b - a)
        );
        for ( int i=0; i<nums.length; i++ ) {
            pq.add(nums[i]);
        }
        int count = 0;
        while ( !pq.isEmpty() && pq.peek() != 0 ) {
            int x = pq.poll();
            if ( !pq.isEmpty() ) {
                int y = pq.poll();
                if ( x != 0 ) pq.add(--x);
                if ( y != 0 ) pq.add(--y);
            } else {
                if ( x != 0 ) pq.add(--x);
            }
            count++;
        }
        return count;
    }
}