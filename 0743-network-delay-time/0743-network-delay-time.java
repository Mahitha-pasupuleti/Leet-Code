class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for ( int[] time : times ) {
            adjMap.computeIfAbsent(time[0], h -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        timeTaken[k] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, k});

        while ( !queue.isEmpty() ) {
            int[] top = queue.poll();
            int time = top[0];
            int node = top[1];

            List<int[]> destList = adjMap.get(node);
            if ( destList != null ) {
                for ( int[] dest : destList ) {
                    if ( time + dest[1] < timeTaken[dest[0]] ) {
                        timeTaken[dest[0]] = time + dest[1];
                        queue.add(new int[]{timeTaken[dest[0]], dest[0]});
                    }
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for ( int i=1; i<=n; i++ ) {
            maxVal = Math.max(maxVal, timeTaken[i]);
        }

        return maxVal == Integer.MAX_VALUE ? -1 : maxVal;
    }
}