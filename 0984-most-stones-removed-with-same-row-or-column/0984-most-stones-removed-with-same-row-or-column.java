class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Build the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // By building the adjacency list we keep a track of all those stones,
        // which are in same row and same column as our current stone
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adjList.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        System.out.println(adjList);

        boolean[] visited = new boolean[n];
        int clusters = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        // BFS to count connected components
        // since our stones are our graph nodes, we need to check if they are visited or not
        for (int i = 0; i < n; i++) { 
            if (!visited[i]) {
                clusters++;
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    List<Integer> neighbors = adjList.get(curr);
                    if ( neighbors != null ) {
                        for (int neighbor : neighbors) {
                            if (!visited[neighbor]) {
                                visited[neighbor] = true;
                                queue.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return n - clusters;  // Max stones to remove = total - number of components
    }
}
