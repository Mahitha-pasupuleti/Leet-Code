class DSU {
    int[] rank;
    int[] parent;

    public DSU(int n) {
        rank = new int[n+1];
        parent = new int[n+1];

        for ( int i=1; i<=n; i++ ) {
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

        if (leader_a == leader_b) return false;

        if (rank[leader_a] < rank[leader_b]) {
            rank[leader_b] += rank[leader_a];
            parent[leader_a] = leader_b;
        } else {
            rank[leader_a] += rank[leader_b];
            parent[leader_b] = leader_a;
        }

        return true; // successfully merged
    }
}
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int k = m*n;
        DSU dsu = new DSU(k);
        int noofIslands = 0;
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        int[][] grid = new int[m][n];
        int[][] valueGrid = new int[m][n];

        int value = 1;
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                grid[i][j] = 0;
                valueGrid[i][j] = value++;
            }
        }

        for ( int[] position : positions ) {
            int x = position[0];
            int y = position[1];

            if (grid[x][y] == 1) {
                result.add(noofIslands); // already land, skip
                continue;
            }

            grid[x][y] = 1;
            noofIslands++;

            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if ( dx<0 || dy<0 || dx>=m || dy>=n ) continue;
                if ( grid[dx][dy] == 1 ) {
                    boolean merged = dsu.union( valueGrid[dx][dy], valueGrid[x][y] );
                    if ( merged ) noofIslands--;
                }
            }
            result.add(noofIslands);
        }

        return result;
    }
}