class Solution {
    int countEdgesToRemove = 0;
    private void dfs( Map<Integer, List<Integer>> adjList, boolean[] visited, int source ) {
        visited[source] = true;
        List<Integer> destList = adjList.get(source);
        if ( destList != null ) {
            for ( int x : destList ) {
                if ( visited[ Math.abs(x) ] ) continue;
                if ( x>0 ) countEdgesToRemove++; // there is an outgoing edge from zero
                dfs(adjList, visited, Math.abs(x));
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];

        for ( int[] edge : connections ) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add( edge[1] );
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add( -edge[0] );
        }

        dfs(adjList, visited, 0);
        return countEdgesToRemove;
    }
}
