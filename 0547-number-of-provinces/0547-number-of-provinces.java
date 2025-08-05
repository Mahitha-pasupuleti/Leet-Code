
// Why we use a HashSet with find(i) to count components:
// - parent[i] alone may not point to the true root due to lazy updates in DSU
// - find(i) applies path compression and returns the actual leader of the component
// - Using a HashSet to collect unique leaders ensures we accurately count components
// ❌ Comparing parent[i] != parent[i+1] is incorrect:
//   - It only checks adjacent indices, which can belong to the same or different components
//   - It also doesn't apply path compression, so it may miss true leaders

/*
    1. Wrong assumption: adjacent indices represent different components
It assumes that parent[i] != parent[i+1] implies a new component.

That’s not necessarily true in disjoint sets.

Node 0 and node 2 may belong to different components, but your logic won't catch that because you only compare i and i+1.

2. parent[i] might not be the actual root
In Union-Find, the parent[] array is not guaranteed to have direct root pointers unless you've called find(i) (which does path compression).

For example, parent[3] = 2, parent[2] = 1, parent[1] = 1. So the root of 3 is 1, but parent[3] = 2 — it’s not updated until you call find(3).

\U0001f534 So just comparing parent[i] and parent[i+1] will:

Miss disconnected components (non-adjacent)

Misidentify components because the true root isn't being checked
*/

class DSU {
    int[] rank;
    int[] parent;

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

    // public int getComponentCount() {
    //     int count = 0;
    //     for ( int i=0; i<parent.length; i++ ) {
    //         if ( parent[i] != parent[i+1] ) count++;
    //     }
    //     return count;
    // }

    public int getComponentCount() {
        Set<Integer> components = new HashSet<>();
        for ( int i=0; i<parent.length; i++ ) {
            components.add( find(i) );
        }
        return components.size();
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( isConnected[i][j] == 1 ) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.getComponentCount();
    }
}