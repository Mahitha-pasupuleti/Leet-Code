class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n+1];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int[] relation : relations ) {
            adjList.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
            inDegree[relation[1]]++;
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        int semesters = 0, courses = 0;

        for ( int i=1; i<=n; i++ ) {
            if ( inDegree[i] == 0 ) bfs.add(i);
        }

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int node = bfs.poll();
                courses++;
                List<Integer> edgeList = adjList.get(node);
                if ( edgeList != null ) {
                    for ( int edge: edgeList ) {
                        inDegree[edge]--;
                        if ( inDegree[edge] == 0 ) {
                            bfs.add(edge);
                        }
                    }
                }
            }
            semesters++;
        }

        return courses == n ? semesters : -1 ;
    }
}

// the level