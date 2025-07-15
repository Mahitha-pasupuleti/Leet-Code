class Solution {
    private void dfs(boolean[] visited, Map<Integer, List<Integer>> adjList, int source) {
        if ( visited[source] ) return;
        visited[source] = true;
        List<Integer> destList = adjList.get(source);
        if ( destList != null ) {
            for ( int x : destList ) {
                dfs(visited, adjList, x);
            }
        }
    }
    public int findChampion(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[n];
        for ( int[] edge : edges ) {
            inDegree[edge[1]]++;
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        int candidate = -1;
        for ( int i=0; i<n; i++ ) {
            if ( inDegree[i] == 0 ) {
                if ( candidate != -1 ) return -1;
                candidate = i;
            }
        }
        if (candidate == -1) return -1;

        boolean[] visited = new boolean[n];
        dfs(visited, adjList, candidate);
        for ( int j=0; j<n; j++ ) {
            if ( !visited[j] ) return -1;
        }

        return candidate;
    }
}