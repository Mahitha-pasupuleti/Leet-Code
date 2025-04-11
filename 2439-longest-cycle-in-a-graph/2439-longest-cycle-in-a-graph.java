class Solution {
    // length of linkedList
    public boolean DFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int source, List<Integer> exactPath) {
        // path[source] = 1;
        exactPath.add(source);
        visited[source] = true;
        List<Integer> destList = adjList.get(source);
        if ( destList != null ) {
            for ( int x : destList ) {
                if ( !visited[x] ) {
                    if ( DFS(adjList, visited, x, exactPath) ) {
                        return true;
                    }
                } else if ( exactPath.contains(x) ) {
                    exactPath.add(x);
                    return true;
                }
            }
        }
        // path[source] = 0;
        exactPath.remove(exactPath.size()-1);
        return false;
    }
    public int longestCycle(int[] edges) {
        // check cycle in directed graph
        // check if the node already visited in the same path

        int n = edges.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        // int[] path = new int[n];
        List<Integer> exactPath = new ArrayList();

        // for ( int i=0; i<n; i++ ) {

        // }

        for ( int i=0; i<n; i++ ) {
            visited[i] = false;

            if ( edges[i] == -1 ) continue;
            // int source = i;
            // int destination = edges[i];
            adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(edges[i]);
        }

        int longestCycle = -1;

        for ( int i=0; i<n; i++ ) {
            if ( !visited[i] ) {
                if ( DFS(adjList, visited, i, exactPath) ) {
                    int cycle = exactPath.get(exactPath.size()-1);
                    longestCycle = Math.max(longestCycle, exactPath.size() - exactPath.indexOf(cycle) - 1);
                }
                exactPath.clear();
            }
        }

        return longestCycle;

    }
}