class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean isTrue = false;
    private void dfs(char[][] board, String word, boolean[][] visited, int x, int y, int k) {
        if ( x<0 || y<0 || x>=board.length || y>=board[0].length || visited[x][y] ) return;
        if ( board[x][y] != word.charAt(k) ) return;
        if ( k == word.length()-1 ) {
            isTrue = true;
            return;
        }
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            dfs(board, word, visited, dx, dy, k+1);
        }
        visited[x][y] = false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                boolean[][] visited = new boolean[n][m];
                dfs(board, word, visited, i, j, 0);
                if ( isTrue ) return true;
            }
        }
        return false;
    }
}