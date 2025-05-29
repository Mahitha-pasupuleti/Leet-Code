class Solution {
    public int solve(int i, int j1, int j2, int rows, int cols, int[][] grid, Map<String, Integer> memo) {
        // invalid conditions
        if ( j1 < 0 || j2 < 0 || j1 >= cols || j2 >= cols ) return (int)-1e8;
        // reached destination
        if ( i == rows-1 ) {
            if ( j1 == j2 ) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        // Memoization
        String key = i + ":" + j1 + ":" + j2;
        if ( memo.containsKey(key) ) return memo.get(key);
        // explore all paths
        int maxi = (int)-1e8;
        for ( int dj1 = -1; dj1 <= 1; dj1++ ) {
            for ( int dj2 = -1; dj2 <= 1; dj2++ ) {
                int value = 0;
                if ( j1 == j2 ) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += solve(i+1, j1+dj1, j2+dj2, rows, cols, grid, memo);
                maxi = Math.max(maxi, value);
            }
        }
        memo.put(key, maxi);
        return maxi;
    }
    public int cherryPickup(int[][] grid) {
        // invoke wtih all positions
        int rows = grid.length;
        int cols = grid[0].length;
        Map<String, Integer> memo = new HashMap<>();
        return solve(0, 0, cols-1, rows, cols, grid, memo);
    }
}