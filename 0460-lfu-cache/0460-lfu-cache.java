class LFUCache {
    Map<Integer, Integer> keyToVal = new HashMap<>();
    Map<Integer, Integer> keyToFreq = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    int capacity;
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        int currFreq = keyToFreq.get(key);
        freqToKeys.get(currFreq).remove(key);

        // if this was the only key in this freq
        if (freqToKeys.get(currFreq).isEmpty()) {
            freqToKeys.remove(currFreq);
            if (currFreq == minFreq) minFreq++;
        }

        // update frequency
        keyToFreq.put(key, currFreq + 1);
        freqToKeys.computeIfAbsent(currFreq + 1, k -> new LinkedHashSet<>()).add(key);

        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        // If key already exists: update value + bump freq
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);   // reuse logic
            return;
        }

        // If full: evict LFU
        if (keyToVal.size() == capacity) {
            int evict = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evict);
            if (freqToKeys.get(minFreq).isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToVal.remove(evict);
            keyToFreq.remove(evict);
        }

        // Insert new key with freq = 1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
}
