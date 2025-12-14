class Pair {
    char key;
    int value;

    public Pair(char key, int value) {
        this.key = key;
        this.value = value;
    }

    public char getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
class Solution {
    public String reorganizeString(String s) {
        StringBuilder str = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for ( int i=0; i<s.length(); i++ ) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        for ( char key : map.keySet() ) {
            pq.add(new Pair(key, map.get(key)));
        }

        while ( pq.size() > 1 ) {
            Pair first = pq.poll();
            Pair second = pq.poll();

            str.append(first.getKey());
            str.append(second.getKey());

            if ( first.getValue() - 1 > 0 ) pq.add(new Pair(first.getKey(), first.getValue()-1));
            if ( second.getValue() - 1 > 0 ) pq.add(new Pair(second.getKey(), second.getValue()-1));
        }

        if ( !pq.isEmpty() ) {
            Pair entry = pq.poll();
            if ( entry.getValue() > 1 ) return "";
            str.append(entry.getKey());
        }

        return str.toString();
    }
}