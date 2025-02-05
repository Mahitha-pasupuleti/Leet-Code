class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        // for ( int i=0; i<s.length(); i++ ) {
        //     if ( map.containsKey(s.charAt(i)) ) {
        //         int value = map.get(s.charAt(i));
        //         map.put(s.charAt(i), ++value);
        //     } else {
        //         map.put(s.charAt(i), 1);
        //     }
        // }

        for ( int i=0; i<s.length(); i++ ) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        // for ( Map.Entry<Character, Integer> x : map.entrySet() ) {
        //     pq.add(x);
        // }

        pq.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        while ( !pq.isEmpty() ) {
            Map.Entry<Character, Integer> currEntry = pq.poll();
            Character key = currEntry.getKey();
            int value = currEntry.getValue();
            while ( value != 0 ) {
                result.append(key);
                value--;
            }
        }

        return result.toString();

    }
}