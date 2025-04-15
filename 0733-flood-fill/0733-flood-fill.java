class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // we have info
        // minimum one value will exist
        // matrix not null

        // BFS
        // [0, 0] => [-1, 0], [1, 0], [0, -1], [0, 1]
        int[][] adj = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        int m = image.length;
        int n = image[0].length;

        int source = image[sr][sc];

        boolean[][] visited = new boolean[m][n];
        // for ( int i=0; i<m; i++ ) {
        //     for ( int j=0; j<n; j++ ) {
        //         visited[i][j] = false;
        //     }
        // }

        Queue<int[]> BFS = new LinkedList();
        BFS.add(new int[]{sr, sc});

        while ( !BFS.isEmpty() ) {
            int[] node = BFS.poll();
            int x = node[0], y = node[1];
            if ( x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || image[x][y] != source ) continue;

            visited[x][y] = true;
            image[x][y] = color;

            for ( int i=0; i<4; i++ ) {
                int newX = x + adj[i][0];
                int newY = y + adj[i][1];
                BFS.add( new int[]{newX, newY} );
            }
        }

        return image;

    }
}