class MyCalendarTwo {
    private TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        this.map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int bookingTillNow = 0;
        int maxBooking = 0;
        for ( int value : map.values() ) {
            bookingTillNow += value;
            maxBooking = Math.max(maxBooking, bookingTillNow);
            if ( maxBooking > 2 ) {
                map.put(startTime, map.get(startTime) - 1);
                map.put(endTime, map.get(endTime) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */