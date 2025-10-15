class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for ( int i=0; i<n; i++ ) {
            parent[i] = i;
            size[i] = 1;
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
            if ( size[leader_a] < size[leader_b] ) {
                size[leader_b] += size[leader_a];
                parent[leader_a] = leader_b;
            } else {
                size[leader_a] += size[leader_b];
                parent[leader_b] = leader_a;
            }
        }
    }

    public int getSize(int node) {
        return size[node];
    }

    // public void print() {
    //     System.out.println( Arrays.toString(parent) );
    //     System.out.println( Arrays.toString(size) );
    // }
}
class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(int x, int y, int n, boolean[][] visited, int[][] grid, DSU dsu) {
        if ( visited[x][y] ) return;
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = dir[0] + x;
            int dy = dir[1] + y;
            if ( dx<0 || dy<0 || dx>=n || dy>=n || visited[dx][dy] || grid[dx][dy] == 0 ) continue;
            // System.out.println( x * n + y + " : " + dx * n + dy );
            dsu.union( x * n + y, dx * n + dy );
            dfs(dx, dy, n, visited, grid, dsu);
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int cells = n * n;

        DSU dsu = new DSU(cells);
        boolean[][] visited = new boolean[n][n];

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 1 ) {
                    dfs(i, j, n, visited, grid, dsu);
                }
            }
        }

        // dsu.print();

        int maxSize = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 0 ) {
                    int currSize = 1;
                    Set<Integer> set = new HashSet<>();
                    for ( int[] dir : directions ) {
                        int dx = dir[0] + i;
                        int dy = dir[1] + j;
                        if ( dx<0 || dy<0 || dx>=n || dy>=n || grid[dx][dy] == 0 ) continue;
                        int parentOf = dsu.find(dx * n + dy);
                        if ( set.contains(parentOf) ) continue;
                        set.add(parentOf);
                        currSize += dsu.getSize(parentOf);
                    }
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }

        if (maxSize == 0) return n * n;

        return maxSize;
    }
}

// if there is only 1 island, and 0's avalble jsut add 1 to island size
// if multiple islands exists. We need to actively check if they can be joined effeciently