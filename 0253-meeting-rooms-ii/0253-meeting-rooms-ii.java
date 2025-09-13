class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort( intervals, (a, b) -> (a[0] - b[0]) );

        int noofMeetingRooms = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-Heap

        for ( int i=0; i<intervals.length; i++ ) {
            if ( !pq.isEmpty() && pq.peek() <= intervals[i][0] ) 
                pq.poll(); // if not overlapping free up prior 
            else
                noofMeetingRooms++;
            pq.add(intervals[i][1]);
        }

        return noofMeetingRooms;
    }
}