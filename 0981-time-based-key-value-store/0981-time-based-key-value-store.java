class Pair {
    int timestamp;
    String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getTime() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key);
        if ( values == null ) return "";
        int start = 0, end = values.size()-1;
        int result = -1;
        while ( start <= end ) {
            int mid = start + (end - start) / 2;
            if ( values.get(mid).getTime() <= timestamp ) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        if ( result == -1 ) return "";
        return values.get(result).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */