import java.util.*;

class DSU {
    int[] parent, rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
    }
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if(pa == pb) return false;
        if(rank[pa] < rank[pb]) {
            parent[pa] = pb;
            rank[pb] += rank[pa];
        } else {
            parent[pb] = pa;
            rank[pa] += rank[pb];
        }
        return true;
    }
}

class Solution {

    private int kruskal(int n, int[][] edges, int excludeEdge, int includeEdge) {
        DSU dsu = new DSU(n);
        int weight = 0;

        // Include forced edge first
        if(includeEdge != -1) {
            weight += edges[includeEdge][2];
            dsu.union(edges[includeEdge][0], edges[includeEdge][1]);
        }

        for(int i=0; i<edges.length; i++) {
            if(i == excludeEdge) continue;
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(dsu.union(u,v)) weight += w;
        }

        // Check if all nodes connected
        for(int i=0; i<n; i++) {
            if(dsu.find(i) != dsu.find(0)) return Integer.MAX_VALUE;
        }

        return weight;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for(int i=0; i<m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i; // original index
        }

        // Sort by weight
        Arrays.sort(newEdges, (a,b) -> a[2]-b[2]);
        int mstWeight = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for(int i=0; i<m; i++) {
            // Critical check: if excluding edge increases MST weight
            if(kruskal(n, newEdges, i, -1) > mstWeight) {
                critical.add(newEdges[i][3]);
            }
            // Pseudo-critical check: if including edge preserves MST weight
            else if(kruskal(n, newEdges, -1, i) == mstWeight) {
                pseudo.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }
}
