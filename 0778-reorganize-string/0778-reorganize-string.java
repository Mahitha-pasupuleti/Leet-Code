import java.util.*;
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for ( int i=0; i<s.length(); i++ ) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (b.getValue() - a.getValue())
        );
        pq.addAll(map.entrySet());

        StringBuilder str = new StringBuilder();

        while ( pq.size() > 1 ) {
            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();

            str.append(first.getKey());
            str.append(second.getKey());

            if ( first.getValue() - 1 > 0 ) pq.add( new AbstractMap.SimpleEntry<>(first.getKey(), first.getValue() - 1));
            if ( second.getValue() - 1 > 0 ) pq.add( new AbstractMap.SimpleEntry<>(second.getKey(), second.getValue() - 1));
        }

        if ( !pq.isEmpty() ) {
            Map.Entry<Character, Integer> entry = pq.poll();
            if ( entry.getValue() > 1 ) return "";
            str.append(entry.getKey());
        }

        return str.toString();
    }
}