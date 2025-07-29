class Solution {
    private boolean dfs( Map<Integer, List<Integer>> adjList, int[] color, int source, int currColor) {
        color[source] = currColor;
        List<Integer> edgeList = adjList.get(source);
        if ( edgeList != null ) {
            for ( int edge : edgeList ) {
                if ( color[edge] == currColor ) return false;
                if ( color[edge] != -1 ) continue;
                if ( !dfs(adjList, color, edge, 1 - currColor) ) return false; // can't be bipartite
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for ( int[] dislike : dislikes ) {
            adjList.computeIfAbsent(dislike[0], k -> new ArrayList<>()).add( dislike[1] );
            adjList.computeIfAbsent(dislike[1], k -> new ArrayList<>()).add( dislike[0] );
        }

        for ( int i=1; i<=n; i++ ) {
            if ( color[i] == -1 && !dfs(adjList, color, i, 0) ) return false;
        }

        return true;
    }
}