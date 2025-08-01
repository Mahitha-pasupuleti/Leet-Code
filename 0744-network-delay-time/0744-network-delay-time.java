class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for ( int[] time : times ) {
            adjMap.computeIfAbsent(time[0], h -> new ArrayList<>()).add( new int[]{time[1], time[2]} );
        }

        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        timeTaken[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.add(new int[]{0, k}); // initial source node

        while ( !pq.isEmpty() ) {
            int[] top = pq.poll();
            int delay = top[0];
            int nodeValue = top[1];

            List<int[]> nodeList = adjMap.get(nodeValue);
            if ( nodeList != null ) {
                for ( int[] node : nodeList ) {
                    if ( timeTaken[node[0]] <= delay + node[1] ) continue;
                    timeTaken[node[0]] = delay + node[1];
                    pq.add( new int[]{ delay + node[1], node[0] } );
                }
            }
        }

        int networkDelayTime = Integer.MIN_VALUE;
        for ( int i=1; i<=n; i++ ) {
            networkDelayTime = Math.max(networkDelayTime, timeTaken[i]);
        }

        if ( networkDelayTime == Integer.MAX_VALUE ) return -1;

        return networkDelayTime;
    }
}