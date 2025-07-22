class Solution {
    // Now this is topological sort
    private boolean dfs(Map<Integer, List<Integer>> adjMap, int[] path, int source, List<Integer> result) {
        path[source] = 2;
        List<Integer> destList = adjMap.get(source);
        if ( destList != null ) {
            for ( int edge : destList ) {
                if ( path[edge] == 1 ) continue;
                if ( path[edge] == 2 ) return true;
                if ( dfs(adjMap, path, edge, result) ) return true;
            }
        }
        result.addFirst(source);
        path[source] = 1;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] path = new int[numCourses];

        for ( int[] prerequisite : prerequisites ) {
            adjMap.computeIfAbsent( prerequisite[1], k -> new ArrayList<>() ).add( prerequisite[0] );
        }

        List<Integer> result = new ArrayList<>();

        for ( int i=0; i<numCourses; i++ ) {
            if ( path[i] != 0 ) continue;
            if ( dfs(adjMap, path, i, result) ) return new int[]{};
        }

        int[] sortedOrder = new int[numCourses];
        for ( int i=0; i<numCourses; i++ ) {
            sortedOrder[i] = result.get(i);
        }

        return sortedOrder;
    }
}