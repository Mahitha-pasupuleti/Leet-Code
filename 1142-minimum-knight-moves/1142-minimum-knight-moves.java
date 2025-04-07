class Solution {
    public int minKnightMoves(int t_x, int t_y) {
        // Infinite board
        // How to handle visited?
        // I am thinking use Map
        // Return minDistance

        // int[] source = {0, 0};
        int level = 0;
        int target_x = Math.abs(t_x);
        int target_y = Math.abs(t_y);

        int[][] coordinates = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0);

        Queue<int[]> BFS = new LinkedList<>();
        BFS.add(new int[]{0, 0});

        while ( !BFS.isEmpty() ) {
            int queueSize = BFS.size();
            while ( queueSize != 0 ) {
                int[] current = BFS.poll();
                int x = current[0], y = current[1];
                if ( x == target_x && y == target_y ) return level;
                for ( int[] move : coordinates ) {
                    int X = x + move[0];
                    int Y = y + move[1];
                    String key = X + "," + Y;
                    if ( !visited.contains(key) && X >= -1 && Y >= -1  ) {
                        BFS.add(new int[]{X, Y});
                        visited.add(key);
                    }
                }
                queueSize--;
            }
            level++;
        }

        return -1;
    }
}