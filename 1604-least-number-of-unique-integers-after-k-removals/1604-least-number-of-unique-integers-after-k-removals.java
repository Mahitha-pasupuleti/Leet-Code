class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> myMap = new HashMap<>();
        for ( int x : arr ) {
            myMap.put(x, myMap.getOrDefault(x, 0)+1);
        }

        List<int[]> myList = new ArrayList<>();
        for ( Map.Entry<Integer, Integer> entry : myMap.entrySet() ) {
            myList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        for ( int[] x : myList ) {
            pq.add(x);
        }

        while ( k!=0 ) {
            int[] entry = pq.poll();
            if (entry[1] <= k) {
                k -= entry[1];
            } else {
                entry[1] -= k;
                k = 0;
                pq.add(entry);
            }
        }

        return pq.size();
    }
}