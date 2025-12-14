class Solution {
    private boolean areQueensPeaceful(int x, int y, int n, Set<String> isQueen) {
        // check vertically
        for ( int row=0; row<n; row++ ) {
            if ( row == x ) continue;
            if ( isQueen.contains(row + ":" + y) ) {
                return false;
            }
        }
        // check diagonally
        int[][] diagonals = {{-1,-1},{-1,1},{1,-1},{1,1}};
        for ( int[] diag : diagonals ) {
            int dx = x + diag[0];
            int dy = y + diag[1];
            while ( dx>=0 && dy>=0 && dx<n && dy<n ) {
                if ( isQueen.contains(dx + ":" + dy) ) {
                    return false;
                }
                dx += diag[0];
                dy += diag[1];
            }
        }
        return true;
    }
    private void solve(int row, int n, List<List<String>> result, Set<String> mySet) {
        if ( row == n ) {
            result.add(buildBoard(n, mySet));
            return;
        }
        for ( int col=0; col<n; col++ ) {
            if ( !areQueensPeaceful(row, col, n, mySet) ) continue;
            mySet.add(row + ":" + col);
            solve(row+1, n, result, mySet);
            mySet.remove(row + ":" + col);
        }
    }
    private List<String> buildBoard(int n, Set<String> queens) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder(".".repeat(n));
            for (int c = 0; c < n; c++) {
                if (queens.contains(r + ":" + c)) {
                    sb.setCharAt(c, 'Q');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<String> mySet = new TreeSet<>();
        solve(0, n, result, mySet);
        return result;
    }
}