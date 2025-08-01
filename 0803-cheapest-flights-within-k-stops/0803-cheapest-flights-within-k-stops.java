class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for ( int[] flight : flights ) {
            adjList.computeIfAbsent(flight[0], h -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.add(new int[]{0, src});

        int[] cheapest = new int[n];
        Arrays.fill(cheapest, Integer.MAX_VALUE);
        cheapest[src] = 0;

        int resultDistance = Integer.MAX_VALUE;

        int level = 1;

        while ( !bfs.isEmpty() ) {

            if ( level > k+2 ) break;

            int size = bfs.size();
            for ( int i=0; i<size; i++ ) {
                int[] top = bfs.poll();
                int dist = top[0]; // 100
                int node = top[1]; // 1

                if ( node == dst && level <= k+2 ) {
                    resultDistance = Math.min(resultDistance, dist);
                } 

                List<int[]> destList = adjList.get(node);
                if ( destList != null ) {
                    for ( int[] dest: destList ) {
                        int destNode = dest[0];
                        int destDistance = dest[1];

                        if ( cheapest[destNode] > dist + destDistance ) {
                            cheapest[destNode] = dist + destDistance;
                            bfs.add( new int[]{ cheapest[destNode], destNode} );
                        }
                    }
                }
            }

            level++;
        }

        if ( resultDistance == Integer.MAX_VALUE ) return -1;
        return resultDistance;
    }
}