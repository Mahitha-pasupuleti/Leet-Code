class Solution {
    public boolean DFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int[] path, int source, List<Integer> result) {
        path[source] = 1;
        visited[source] = true;
        List<Integer> neighbours = adjList.get(source);
        if ( neighbours != null ) {
            for ( int x : neighbours ) {
                if ( !visited[x] ) {
                    if ( DFS(adjList, visited, path, x, result) ) return true;
                } else if ( path[x] == 1 ) {
                    return true;
                }
            }
        }
        path[source] = 0;
        result.add(source);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        int[] path = new int[numCourses];

        for ( int i=0; i<numCourses; i++ ) {
            visited[i] = false;
            path[i] = 0;
        }

        for ( int[] preq : prerequisites ) {
            adjList.computeIfAbsent(preq[0], k -> new ArrayList()).add(preq[1]);
        }

        // System.out.println(adjList);

        List<Integer> result = new ArrayList<>();
        // int[] result = new int[numCourses];

        for ( int i=0; i<numCourses; i++ ) {
            if ( !visited[i] ) {
                if ( DFS(adjList, visited, path, i, result) ) return new int[0];
            }
        }

        // System.out.println(result);
        int[] arr = new int[numCourses];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}