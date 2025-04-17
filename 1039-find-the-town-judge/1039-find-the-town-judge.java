class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        // [0, 1, 2]

        for ( int[] t : trust ) {
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }

        for ( int i=1; i<=n; i++ ) {
            if ( outDegree[i] == 0 ) {
                if ( inDegree[i] == n-1 ) return i;
            }
        }

        return -1;
    }
}

/* 
class Solution {
    public int findJudge(int n, int[][] trust) {
        if ( n == 1 ) return 1;

        List<Integer> persons = new ArrayList();
        Map<Integer, Integer> destMap = new HashMap<>();

        for ( int[] source: trust ) {
            persons.add(source[0]);
            destMap.put(source[1], destMap.getOrDefault(source[1], 0) + 1);
        }

        for ( int i=1; i<=n; i++ ) {
            if ( !persons.contains(i) && destMap.containsKey(i) && destMap.get(i) == n-1 ) return i;
        }

        return -1;
    }
}
*/