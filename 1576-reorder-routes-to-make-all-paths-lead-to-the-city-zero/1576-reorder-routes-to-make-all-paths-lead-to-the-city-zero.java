class Solution {
    public int minReorder(int n, int[][] connections) {
        // 0 to n-1, n-1 roads
        // directed graph
        // road edges given
        // source 0
        // minimum edges needed
        // from source traverse all nodes?

        // Using BFS
        // If you are able to go to a node other than 0, you need to change the edge direction. 
        // Because all the roads should move towards '0' not in other direction

        // Create adjancy List and visited List

        Map<Integer, List<Integer>> adjList_Forward = new HashMap<>();
        Map<Integer, List<Integer>> adjList_Backward = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for ( int[] edge : connections ) {
            int source = edge[0];
            int destination = edge[1];

            adjList_Forward.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adjList_Backward.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);

            visited.putIfAbsent(source, false);
            visited.putIfAbsent(destination, false);
        }

        // System.out.println(adjList_Forward);
        // System.out.println(adjList_Backward);
        // System.out.println(visited);

        Queue<Integer> BFS = new LinkedList<>();
        BFS.add(0);
        visited.put(0, true);

        int count = 0;

        while ( !BFS.isEmpty() ) {
            int topEle = BFS.poll();
            List<Integer> currFw = adjList_Forward.get(topEle);
            List<Integer> currBw = adjList_Backward.get(topEle);
            if ( currFw != null ) {
                for (int x : currFw ) {
                    if ( !visited.get(x) ) {
                        BFS.add(x);
                        visited.put(x, true);
                        count++;
                    }
                } 
            }
            if ( currBw != null ) {
                for (int x : currBw ) {
                    if ( !visited.get(x) ) {
                        BFS.add(x);
                        visited.put(x, true);
                    }
                } 
            }
        }

        return count;
    }
}