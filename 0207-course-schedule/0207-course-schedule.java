class Solution {
    private boolean dfs(Map<Integer, List<Integer>> adjList, int[] path, int source) {
        path[source] = 2;
        List<Integer> destList = adjList.get(source);
        if ( destList != null ) {
            for ( int edge : destList ) {
                if ( path[edge] == 0 ) {
                    if ( dfs(adjList, path, edge) ) return true;
                } else if ( path[edge] == 2 ) {
                    return true;
                }
            }
        }
        path[source] = 1;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] path = new int[numCourses];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int[] prerequisite : prerequisites ) {
            adjList.computeIfAbsent( prerequisite[1], k -> new ArrayList<>() ).add( prerequisite[0] );
        }

        for ( int i=0; i<numCourses; i++ ) {
            if ( path[i] == 0 ) {
                if ( dfs(adjList, path, i) ) return false;
            }
        }

        return true;

    }
}

// find if cycle exists in directed graph
// How to find cycle in directed graph : should not be in the same path