class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for ( int[] preq : prerequisites ) {
            adjList.computeIfAbsent(preq[0], k -> new ArrayList<>()).add(preq[1]);
            ++inDegree[preq[1]];
        }

        Queue<Integer> bfs = new ArrayDeque<>();

        for ( int i=0; i<numCourses; i++ ) {
            if ( inDegree[i] == 0 ) bfs.add(i);
        }

        if ( bfs.isEmpty() ) return false;

        int count = 0;
        while ( !bfs.isEmpty() ) {
            int top = bfs.poll();
            count++;
            List<Integer> nodes = adjList.get(top);
            if ( nodes != null ) {
                for ( int node : nodes ) {
                    inDegree[node]--;
                    if ( inDegree[node] == 0 ) bfs.add(node);
                }
            }
        }

        return count == numCourses;
    }
}