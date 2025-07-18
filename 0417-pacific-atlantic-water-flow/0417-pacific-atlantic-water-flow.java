class Solution {
    private void dfs(int[][] heights, boolean[][] visited, int[][] directions, int x, int y) {
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=heights.length || dy>=heights[0].length || visited[dx][dy] || heights[x][y] > heights[dx][dy] ) continue;
            dfs(heights, visited, directions, dx, dy);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length, cols = heights[0].length;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        for ( int col=0; col<cols; col++ ) {
            dfs(heights, pacificVisited, directions, 0, col);
            dfs(heights, atlanticVisited, directions, rows-1, col);
        }

        for ( int row=0; row<rows; row++ ) {
            dfs(heights, pacificVisited, directions, row, 0);
            dfs(heights, atlanticVisited, directions, row, cols-1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for ( int row=0; row<rows; row++ ) {
            for ( int col=0; col<cols; col++ ) {
                if ( pacificVisited[row][col] && atlanticVisited[row][col] ) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }
}