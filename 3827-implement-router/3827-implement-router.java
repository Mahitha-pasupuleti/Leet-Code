class Router {
    
    int memoryLimit;
    Queue<int[]> storage; // FIFO
    Set<String> mySet; // unique entries
    Map<Integer, List<Integer>> destCount;
    
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.storage = new ArrayDeque<>();
        this.mySet = new HashSet<>();
        this.destCount = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        int[] packet = new int[]{source, destination, timestamp};
        String packetString = source + ":" + destination + ":" + timestamp;
        
        if ( mySet.contains(packetString) ) return false;
        else mySet.add(packetString);

        if ( storage.size() == memoryLimit ) {
            int[] removedPacket = storage.poll();
            String removedPacketString = removedPacket[0] + ":" + removedPacket[1] + ":" + removedPacket[2];
            mySet.remove(removedPacketString);
            destCount.get(removedPacket[1]).remove( Integer.valueOf(removedPacket[2]) );
        }
        storage.add(packet);
        destCount.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if ( storage.isEmpty() ) return new int[]{};
        int[] packet = storage.poll();
        String packetString = packet[0] + ":" + packet[1] + ":" + packet[2];
        mySet.remove(packetString);
        destCount.get(packet[1]).remove( Integer.valueOf(packet[2]) );
        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> destTimes = destCount.get(destination);
        if (destTimes == null || destTimes.isEmpty()) return 0;
    
        int lo = lowerBound(destTimes, startTime);      // first index >= startTime
        int hi = upperBound(destTimes, endTime);        // first index > endTime
    
        return hi - lo;  // number of elements in [startTime, endTime]
    }
    
    // lower bound: first index with value >= target
    private int lowerBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    // upper bound: first index with value > target
    private int upperBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

}
/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */