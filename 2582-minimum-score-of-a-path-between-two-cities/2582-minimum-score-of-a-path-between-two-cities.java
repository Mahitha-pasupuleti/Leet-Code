class Solution {
    int smallestEdge = Integer.MAX_VALUE;
    private void dfs(Map<Integer, List<int[]>> adjList, boolean[] visited, int source) {
        visited[source] = true;
        List<int[]> destList = adjList.get(source);
        if ( destList != null ) {
            for ( int[] edge : destList ) {
                smallestEdge = Math.min(smallestEdge, edge[1] );
                if ( visited[ edge[0] ] ) continue;
                dfs(adjList, visited, edge[0]);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n+1];

        for ( int[] road : roads ) {
            adjList.computeIfAbsent(road[0], k -> new ArrayList<>()).add( new int[]{road[1], road[2]} );
            adjList.computeIfAbsent(road[1], k -> new ArrayList<>()).add( new int[]{road[0], road[2]} );
        }

        dfs(adjList, visited, 1);

        return smallestEdge;
    }
}