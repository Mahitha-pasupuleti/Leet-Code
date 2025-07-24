class DSU {
    private int[] rank;
    private int[] parent;

    public DSU(int n) {
        rank = new int[n+1];
        parent = new int[n+1];

        for ( int i=1; i<n+1; i++ ) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node) {
        if ( parent[node] == node ) return node;
        return parent[node] = find( parent[node] );
    }

    public boolean union(int a, int b) {
        int leader_a = find(a);
        int leader_b = find(b);

        if ( leader_a != leader_b ) {
            if ( rank[leader_a] < rank[leader_b] ) {
                rank[leader_b] += rank[leader_a];
                parent[leader_a] = leader_b;
            } else {
                rank[leader_a] += rank[leader_b];
                parent[leader_b] = leader_a;
            }
        } else {
            return true;
        }

        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU disjoin = new DSU( edges.length );
        for ( int[] edge : edges ) {
            if ( disjoin.union(edge[0], edge[1]) ) return edge;
        }
        return new int[]{0,0};
    }
}