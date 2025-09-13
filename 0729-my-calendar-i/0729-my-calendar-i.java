class MyCalendar {
    private List<int[]> calender;
    public MyCalendar() {
        this.calender = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for ( int[] event : calender ) {
            // check if current event overlaps with any of the existing events
            // for-loop necenssary because we cant sort entirely first like other problems
            if ( Math.max(event[0], startTime) < Math.min(event[1], endTime) ) return false;
        }
        calender.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */