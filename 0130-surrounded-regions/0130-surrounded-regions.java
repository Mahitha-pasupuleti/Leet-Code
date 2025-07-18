class Solution {
    private void dfs(char[][] board, boolean[][] visited, int[][] directions, int x, int y) {
        visited[x][y] = true;
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=board.length || dy>=board[0].length || visited[dx][dy] || board[dx][dy] == 'X' ) continue;
            dfs(board, visited, directions, dx, dy);
        }
    }
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        for ( int col=0; col<cols; col++ ) {
            if ( board[0][col] == 'O' ) {
                dfs(board, visited, directions, 0, col);
            }
            if ( board[rows-1][col] == 'O' ) {
                dfs(board, visited, directions, rows-1, col);
            }
        }

        for ( int row=0; row<rows; row++ ) {
            if ( board[row][0] == 'O' ) {
                dfs(board, visited, directions, row, 0);
            }
            if ( board[row][cols-1] == 'O' ) {
                dfs(board, visited, directions, row, cols-1);
            }
        }

        for ( int row=0; row<rows; row++ ) {
            for ( int col=0; col<cols; col++ ) {
                if ( board[row][col] == 'O' && !visited[row][col] ) board[row][col] = 'X';
            }
        }

    }
}