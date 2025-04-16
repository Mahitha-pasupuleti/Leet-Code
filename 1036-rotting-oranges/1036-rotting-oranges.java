class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS
        // neighbours of 2 must become 2 if they are 1 before
        // find all neighbours of a node(2) at same level whose value is (1)
        // add all nodes(2) into BFS level 0
        // chage 1's to 2's
        // dont touch '0'

        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        int levelCount = -1;
        int countOfOranges = 0;

        Queue<int[]> BFS = new LinkedList<>();
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 2 ) BFS.add(new int[]{i, j});
                else if ( grid[i][j] == 1 ) countOfOranges++;
            }
        }

        if ( countOfOranges == 0 ) return 0;

        int levelSize = 0;

        while ( !BFS.isEmpty() ) {
            levelCount++;
            levelSize = BFS.size();
            while ( levelSize != 0 ) {
                levelSize--;
                int[] node = BFS.poll();
                int x = node[0], y = node[1];

                for ( int[] dir : directions ) {
                    int dx = x + dir[0], dy = y + dir[1];
                    if ( (dx >= 0 && dx < m) && (dy >= 0 && dy < n) && grid[dx][dy] == 1 ) {
                        BFS.add(new int[]{dx, dy});
                        grid[dx][dy] = '2';
                    }
                }
            }
        }

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( grid[i][j] == 1 ) return -1;
            }
        }

        return levelCount;

    }
}