class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for ( int i=0; i<edges.length; i++ ) {
            int srcNode = edges[i][0];
            int destNode = edges[i][1];
            adjList.computeIfAbsent(srcNode, k -> new ArrayList<>()).add(new int[]{destNode, i});
            adjList.computeIfAbsent(destNode, k -> new ArrayList<>()).add(new int[]{srcNode, i});
        }

        double[] maxProb = new double[n];

        Arrays.fill(maxProb, Integer.MIN_VALUE); // to get maximum probabilty, take all min values first
        maxProb[start_node] = 1.0; // the intilaly values changes as per problem requirement

        // MAX-HEAP, since we wan the maximum value
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );
        pq.add(new double[]{1.0, start_node});

        while ( !pq.isEmpty() ) {
            double[] top = pq.poll();
            double probability = top[0];
            int srcNode = (int)top[1];

            List<int[]> neighbors = adjList.get(srcNode);
            if ( neighbors != null ) {
                for ( int[] neighbor : neighbors ) {
                    int destNode = neighbor[0];
                    double destSuccProb = succProb[ neighbor[1] ];

                    if ( maxProb[destNode] < probability * destSuccProb ) { // storing max value
                        maxProb[destNode] = probability * destSuccProb; // multiply as per requirement
                        pq.add(new double[]{maxProb[destNode], destNode});
                    }
                }
            }
        }

        if ( maxProb[end_node] == Integer.MIN_VALUE ) return 0.00000;

        return maxProb[end_node];
    }
}