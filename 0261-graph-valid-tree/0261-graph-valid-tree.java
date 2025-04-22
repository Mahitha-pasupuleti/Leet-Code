class Solution {
    public boolean DFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int source, int parent) {
        visited[source] = true;
        List<Integer> neighbours = adjList.get(source);
        if ( neighbours != null ) {
            for ( int neighbour : neighbours ) {
                if ( !visited[neighbour] ) {
                    if (DFS(adjList, visited, neighbour, source) ) return true;
                } else if ( visited[neighbour] && neighbour != parent ) return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        // check if cycle exists
        // dfs - parent and path
        // visited not parent

        // adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int[] edge : edges ) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList()).add(edge[0]);
        }

        // System.out.println(adjList);

        boolean[] visited = new boolean[n];

        if ( DFS(adjList, visited, 0, -1) ) return false;

        for ( int i=0; i<n; i++ ) {
            if ( visited[i] == false ) return false;
        }

        return true;

    }
}