class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for ( int[] interval : intervals ) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        System.out.println( map );

        int maxRooms = 0;
        int currentRooms = 0;
        for ( int value : map.values() ) {
            currentRooms += value;
            maxRooms = Math.max(maxRooms, currentRooms );
        }
        return maxRooms;
    }
}

// {0=1, 5=1, 15=-1, 16=1, 20=-1, 30=-1} the max will remain 2 since, one meeting is ending before starting another.
// This si genuius alogorithm