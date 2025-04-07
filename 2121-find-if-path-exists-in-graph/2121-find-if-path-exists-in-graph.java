class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // n*n matrix
        // no self edges
        // every vertex has an edge - no null vertices
        // [0] => [1, 2]
        // [1] => [0]
        // [2] => [0]
        // [3] => [4, 5]
        // [4] => [3, 5]
        // [5] => [3, 4]
        // perform traversal

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for ( int[] edge : edges ) {
            int key = edge[0];
            int value = edge[1];

            adjList.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            adjList.computeIfAbsent(value, k -> new ArrayList<>()).add(key);

            visited.putIfAbsent(key, false);
            visited.putIfAbsent(value, false);
        }

        // System.out.println(adjList);
        // System.out.println(visited);

        // List<Integer> result = new ArrayList<>();

        Queue<Integer> BFS = new LinkedList<>();
        BFS.add(source);
        visited.put(source, true);

        while ( !BFS.isEmpty() ) {
            int topEle = BFS.peek();
            if ( topEle == destination ) return true;
            // result.add(topEle);
            List<Integer> destList = adjList.get(BFS.poll());
            if ( destList != null ) {
                for ( int x : destList ) {
                    if ( !visited.get(x) ) BFS.add(x);
                    visited.put(x, true);
                }
            }
        }

        // System.out.println(result);

        // return result.contains(destination) ? true : false;

        return false;
    }
}