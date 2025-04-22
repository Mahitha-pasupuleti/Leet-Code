class Solution {
    public void DFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int source) {
        visited[source] = true;
        List<Integer> neighbours = adjList.get(source);
        if ( neighbours != null ) {
            for ( int neighbour : neighbours ) {
                if ( !visited[neighbour] ) {
                    DFS(adjList, visited, neighbour);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        
        // Adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int[] edge : edges ) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList()).add(edge[0]);
        }

        // Visited
        boolean[] visited = new boolean[n];

        int connectedComponents = 0;

        for ( int i=0; i<n; i++ ) {
            if ( !visited[i] ) {
                connectedComponents++;
                DFS(adjList, visited, i);
            }
        }

        return connectedComponents;
    }
}