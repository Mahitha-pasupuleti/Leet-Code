class Solution {
    /* 
    Goal: We need to connect all the computers (directly or indirectly). We have to return the minimum number of operations that are required to connect the computers. An operation consists of removing a cable between two directly connected computers and put it between two disconnected computers.
    This problem is a simple variation of counting the number of islands.
    We know that the minimum number of edges required for a graph with n nodes to remain connected is n - 1. Similarly, if there are k components in a disconnected graph, then we need at least k - 1 edges to connect every component.
    With that in our mind, we will start with our base condition. If the number of edges in the graph is greater than n - 1 or not. If not, we will return -1.
    Next, we will count the number of components (k). As I already mentioned, we will need k - 1 operations to connect the computers (components). And that is our answer!
    We can also solve this using Union-Find approach and count the number of components. I solved this problem using DFS and the code is shown below.
    */
    public void DFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int source) {
        visited[source] = true;
        List<Integer> computers = adjList.get(source);

        if ( computers != null ) {
            for ( int comp : computers ) {
                if ( !visited[comp] ) {
                    DFS(adjList, visited, comp);
                }
            }
        }

    }
    public int makeConnected(int n, int[][] connections) {
        /* 
        check how many connected components exists
        components - 1 is minimum changes need to be done
        */
        if (connections.length < n - 1) return -1;

        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for ( int[] edge: connections ) {
            int source = edge[0], destination = edge[1];
            adjList.computeIfAbsent(source, k -> new ArrayList()).add(destination);
            adjList.computeIfAbsent(destination, k -> new ArrayList()).add(source);
        }

        int components = 0;

        for ( int i=0; i<n; i++ ) {
            if ( !visited[i] ) {
                components++;
                DFS(adjList, visited, i);
            }
        }

        return components - 1;

        // if ( noOfCycles == 0 || noOfCycles < looseNodes ) return -1;
        // return noOfCycles;
    }
}