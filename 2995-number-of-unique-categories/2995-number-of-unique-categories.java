/**
 * Definition for a category handler.
 * class CategoryHandler {
 *     public CategoryHandler(int[] categories);
 *     public boolean haveSameCategory(int a, int b);
 * };
 */
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for ( int i=0; i<n; i++ ) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if ( node == parent[node] ) return node;
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

    public int getComponents(int n) {
        Set<Integer> set = new HashSet<>();
        for ( int i=0; i<n; i++ ) {
            set.add( find(i) );
        }
        return set.size();
    }
}
class Solution {
	public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        DSU dsu = new DSU(n);

        for ( int i=0; i<n; i++ ) {
            for ( int j=i+1; j<n; j++ ) {
                if ( categoryHandler.haveSameCategory(i, j) ) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.getComponents(n);
	}
}