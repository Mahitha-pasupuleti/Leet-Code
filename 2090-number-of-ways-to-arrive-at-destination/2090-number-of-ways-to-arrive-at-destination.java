class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        long[] minDistance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(minDistance, Long.MAX_VALUE);
        minDistance[0] = 0;
        ways[0] = 1;

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for ( int[] road : roads ) {
            adjList.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adjList.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        pq.add(new long[]{0, 0});

        while ( !pq.isEmpty() ) {
            long[] top = pq.poll();
            long distSrc = top[0];
            int nodeSrc = (int)top[1];

            if (distSrc > minDistance[nodeSrc]) continue;

            List<int[]> edgeList = adjList.get(nodeSrc);
            if ( edgeList != null ) {
                for ( int[] edge : edgeList ) {
                    long distDest = edge[1] + distSrc;
                    int nodeDest = edge[0];

                    if ( minDistance[nodeDest] > distDest ) {
                        minDistance[nodeDest] = distDest;
                        ways[nodeDest] = ways[nodeSrc];
                        pq.add(new long[]{distDest, nodeDest});
                    } else if ( minDistance[nodeDest] == distDest ) {
                        ways[nodeDest] = (ways[nodeDest] + ways[nodeSrc]) % MOD;
                    }
                }
            }
        }

        return ways[n-1];
    }
}