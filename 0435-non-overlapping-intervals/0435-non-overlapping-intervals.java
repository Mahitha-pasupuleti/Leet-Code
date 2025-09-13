class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));
        int end = intervals[0][1];
        int noofRemovals = 0;
        for ( int i=1; i<intervals.length; i++ ) {
            if ( end <= intervals[i][0] ) {
                // prior interval completed no overlap
                end = intervals[i][1];
            } else {
                // overlap exists
                noofRemovals++;
            }
        }
        return noofRemovals;
    }
}

/*
     - use your brain in interval problems
     - first think if sort by start or sort by end are gonna help
*/