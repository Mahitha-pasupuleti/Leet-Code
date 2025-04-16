class Solution {
    public void DFS(char[][] board, boolean[][] visited, int[][] directions, int x, int y, List<Integer> xIndex, List<Integer> yIndex, int m, int n) {
        visited[x][y] = true;
        xIndex.add(x);
        yIndex.add(y);
        for ( int[] dir : directions ) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if ( dx<0 || dx>=m || dy<0 || dy>=n || board[dx][dy] != 'O' || visited[dx][dy] ) continue;
            DFS(board, visited, directions, dx, dy, xIndex, yIndex, m, n);
        }
    }
    public void solve(char[][] board) {
        // '0' connect to form region
        // if '0' on edge of board we cant capture it
        // '0' internally i can capture it
        // row = 0, column = 0, row = m-1, column = n-1 then edge

        // find all '0' filled graphs

        int m = board.length;
        int n = board[0].length;
        if (m == 0) return;
        
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        List<Integer> xIndex = new ArrayList<>();
        List<Integer> yIndex = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> BFS = new LinkedList<>();

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( !visited[i][j] && board[i][j] == 'O' ) {
                    DFS(board, visited, directions, i, j, xIndex, yIndex, m, n);
                    boolean isEdge = false;
                    for ( int k=0; k<xIndex.size(); k++ ) {
                        if ( xIndex.get(k) == 0 || xIndex.get(k) == m-1 || yIndex.get(k) == 0 || yIndex.get(k) == n-1 ) {
                            isEdge = true;
                            break;
                        }
                    }
                    if ( !isEdge ) {
                        for ( int k=0; k<xIndex.size(); k++ ) {
                            board[xIndex.get(k)][yIndex.get(k)] = 'X';
                        }
                    }
                    xIndex.clear();
                    yIndex.clear();
                }
            }
        }

    }
}