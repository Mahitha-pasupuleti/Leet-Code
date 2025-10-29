class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if ( intervals.length == 0 ) return true; 
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int endTime = intervals[0][1];
        for ( int i=1; i<intervals.length; i++ ) {
            if ( endTime > intervals[i][0] ) return false;
            endTime = intervals[i][1];
        }
        return true;
    }
}