class DSU {
    private int[] rank;
    private int[] parent;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for ( int i=0; i<n; i++ ) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node) {
        if ( parent[node] == node ) return node;
        // path compression
        return parent[node] = find( parent[node] );
    }

    public void union(int a, int b) {
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
        }
    }

    public int getComponentCount() {
        Set<Integer> uniqueLeaders = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            uniqueLeaders.add(find(i));  // find ensures path compression
        }
        return uniqueLeaders.size();
    }

}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU disjoin = new DSU(n);
        for ( int[] edge : edges ) {
            disjoin.union(edge[0], edge[1]);
        }
        return disjoin.getComponentCount();
    }
}