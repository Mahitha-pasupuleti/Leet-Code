class Solution {
    private void dfs(int[][] image, boolean[][] visited, int[][] directions, int x, int y, int color) {
        if ( visited[x][y] ) return;
        visited[x][y] = true;
        int cellValue = image[x][y];
        image[x][y] = color;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=image.length || dy>=image[0].length || image[dx][dy] != cellValue ) continue;
            dfs(image, visited, directions, dx, dy, color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        dfs(image, visited, directions, sr, sc, color);
        return image;
    }
}