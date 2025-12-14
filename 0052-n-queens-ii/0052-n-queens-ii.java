class Solution {
    private int solve(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) return 1;

        int result = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1; // shift to avoid negatives
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            // place queen
            cols[col] = diag1[d1] = diag2[d2] = true;

            result += solve(row + 1, n, cols, diag1, diag2);

            // backtrack
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
        return result;
    }

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        return solve(0, n, cols, diag1, diag2);
    }
}
