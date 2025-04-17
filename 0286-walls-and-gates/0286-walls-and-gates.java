class Solution {
    public void wallsAndGates(int[][] rooms) {
        /*
            Similar to House to Well problem, where instead of "H to W", we choose "W to H"
            Find shortest distance from 'Gate' to 'Empty room' using BFS
            Multi-source BFS
            We need to add all Gate's because, if we wait for one Gate to complete BFS
            there are high chances 'Empty Rooms' near to other 'Gates' will not be considered

         */

         int m = rooms.length;
         int n = rooms[0].length;

         Queue<int[]> BFS = new ArrayDeque();
         boolean[][] visited = new boolean[m][n];
         int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

         for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( rooms[i][j] == 0 ) {
                    BFS.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
         }

         int levelSize = 0, levelCount = 0;

         while ( !BFS.isEmpty() ) {
            levelSize = BFS.size();
            while ( levelSize != 0 ) {
                levelSize--;
                int[] node = BFS.poll();
                for ( int[] dir: directions ) {
                    int dx = node[0] + dir[0];
                    int dy = node[1] + dir[1];

                    if ( dx<0 || dx>=m || dy<0 || dy>=n || visited[dx][dy] || rooms[dx][dy] != 2147483647 ) continue;
                    rooms[dx][dy] = (levelCount+1);
                    visited[dx][dy] = true;
                    BFS.add(new int[]{dx, dy});
                }
            }
            levelCount++;
         }


    }
}