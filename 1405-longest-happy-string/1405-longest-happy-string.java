class Pair {
    char key;
    int count;

    public Pair(char key, int count) {
        this.key = key;
        this.count = count;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + count + ")";
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder str = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.count - x.count
        );
        if ( a > 0 ) pq.add(new Pair('a', a));
        if ( b > 0 ) pq.add(new Pair('b', b));
        if ( c > 0 ) pq.add(new Pair('c', c));

        while ( !pq.isEmpty() ) {
            Pair first = pq.poll();
            int len = str.length();
            if ( len >= 2 && str.charAt(len-1) == first.key && str.charAt(len-2) == first.key ) {
                if (pq.isEmpty()) break; 
                Pair second = pq.poll();
                str.append(second.key);
                second.count -= 1; 
                if ( second.count > 0 ) pq.add(second);
                pq.add(first);
            } else {
                str.append(first.key);
                first.count -= 1;
                if ( first.count > 0 ) pq.add(first);
            }
        }

        return str.toString();
    }
}