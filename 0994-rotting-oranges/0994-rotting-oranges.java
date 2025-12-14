class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{-1,0},{0,1},{0,-1},{1,0}};
        Queue<int[]> BFS = new ArrayDeque<>();

        int countOfOranges = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 2 ) {
                    BFS.add(new int[]{i,j});
                } else if ( grid[i][j] == 1 ) countOfOranges++;
            }
        }

        if ( countOfOranges == 0 ) return countOfOranges;

        int level = 0;

        while( !BFS.isEmpty() ) {
            level++;
            int size = BFS.size();
            for ( int i=0; i<size; i++ ) {
                int[] top = BFS.poll();
                for ( int[] dir : directions ) {
                    int dx = top[0] + dir[0];
                    int dy = top[1] + dir[1];
                    if ( dx<0 || dy<0 || dx>=n || dy>=m || grid[dx][dy] != 1 ) continue;
                    grid[dx][dy] = 2;
                    BFS.add(new int[]{dx, dy});
                }
            }
        }

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 1 ) return -1; 
            }
        } 

        return level-1;
    }
}