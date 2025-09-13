class MyCalendarThree {
    private TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        this.map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int noofBookingsCurrently = 0;
        int maxBookings = 0;
        for ( int value : map.values() ) {
            noofBookingsCurrently += value;
            maxBookings = Math.max(maxBookings, noofBookingsCurrently);
        }

        return maxBookings;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */