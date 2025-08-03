class Pair {
    long a; 
    int b;  
    Pair(long a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int mod = (int) (1e9 + 7);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.a, y.a));
        pq.add(new Pair(0L, 0));
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long dis = curr.a;
            int node = curr.b;

            for (Pair i : adj.get(node)) {
                int neigh = i.b;
                long wt = i.a;

                if (dis + wt < dist[neigh]) {
                    dist[neigh] = dis + wt;
                    pq.add(new Pair(dist[neigh], neigh));
                    ways[neigh] = ways[node];
                } else if (dis + wt == dist[neigh]) {
                    ways[neigh] = (ways[neigh] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}