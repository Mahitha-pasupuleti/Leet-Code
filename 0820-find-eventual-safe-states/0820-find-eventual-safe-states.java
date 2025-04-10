class Solution {
    public boolean DFS(int[][] graph, boolean[] visited, int[] path, int source) {
        path[source] = 1;
        visited[source] = true;
        int[] destList = graph[source];
        for ( int x: destList ) {
            if ( !visited[x] ) {
                if ( DFS(graph, visited, path, x) ) {
                    return true;
                }
            } else if ( path[x] == 1 ) {
                return true;
            }
        }
        path[source] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        int[] path = new int[n];

        for ( int i=0; i<n; i++ ) {
            visited[i] = false;
            path[i] = 0;
        }

        List<Integer> result = new ArrayList<>();

        for ( int i=0; i<n; i++ ) {
            if ( !visited[i] ) {
                DFS(graph, visited, path, i);
            }
        }

        for ( int j=0; j<n; j++ ) {
            if ( path[j] == 0 ) result.add(j);
        }

        return result;
    }
}