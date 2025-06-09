class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // K most frequent elements
        Map<Integer, Integer> mostFreq  = new HashMap<>();
        for ( int num : nums ) {
            mostFreq.put( num, mostFreq.getOrDefault( num, 0 ) + 1 );
        }

        // descending order based on value
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (a.getValue() - b.getValue()) // minHeap
        );

        for ( int key : mostFreq.keySet() ) {
            int value = mostFreq.get(key);
            pq.add(new Pair<>(key, value));
            if ( pq.size() > k ) pq.poll(); // pushes out least frequency
        }

        // System.out.println(pq);

        int[] result = new int[k];
        while ( k != 0 ) {
            Pair<Integer, Integer> subResult = pq.poll();
            result[--k] = subResult.getKey();
        }

        return result;
    }
}