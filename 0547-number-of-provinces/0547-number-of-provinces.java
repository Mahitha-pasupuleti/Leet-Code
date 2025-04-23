class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        /* 
            0 1 2
          0 1 1 0
          1 1 1 0
          2 0 0 1

          visited[][]
        */
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( j != i && isConnected[i][j] == 1 ) {
                    adjList.computeIfAbsent(i, k -> new ArrayList()).add(j);
                }
            }
        }

        System.out.println(adjList);

        Queue<Integer> BFS = new ArrayDeque<>();

        // 0, 1, 2

        int noOfProvinces = 0;

        for ( int i=0; i<n; i++ ) {
            if ( !visited[i] ) {
                noOfProvinces++;
                // BFS
                BFS.add(i);
                visited[i] = true;

                while ( !BFS.isEmpty() ) {
                    int node = BFS.poll();
                    List<Integer> neighbours = adjList.get(node);
                    if ( neighbours != null ) {
                        for ( int neighbour: neighbours ) {
                            if ( !visited[neighbour] ) {
                                BFS.add(neighbour);
                                visited[neighbour] = true;
                            }
                        }
                    }
                }
            }
        }

        return noOfProvinces;

    }
}