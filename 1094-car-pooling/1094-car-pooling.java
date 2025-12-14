class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int finalPos = 0;
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        for ( int[] trip : trips ) {
            finalPos = Math.max(finalPos, trip[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[2] - b[2])
        );
        int currPos = 0, j = 0, currCapacity = 0;

        while ( currPos != finalPos ) {
            while ( !pq.isEmpty() && pq.peek()[2] == currPos ) {
                int[] drop = pq.poll();
                currCapacity -= drop[0];
            }
            while ( j < trips.length && trips[j][1] <= currPos ) {
                pq.add(trips[j]);
                currCapacity += trips[j][0];
                if ( currCapacity > capacity ) return false;
                j++;
            }
            currPos++;
        }

        return true;
    }
}