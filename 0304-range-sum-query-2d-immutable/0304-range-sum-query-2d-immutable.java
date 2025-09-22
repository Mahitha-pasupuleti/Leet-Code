class NumMatrix {
    int[][] prefixSum;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = matrix;

        // generate prefixSum matrix
        this.prefixSum = new int[m+1][n+1];

        for ( int row=1; row<=m; row++ ) {
            for ( int col=1; col<=n; col++ ) {
                this.prefixSum[row][col] = matrix[row-1][col-1]
                                        + prefixSum[row-1][col] 
                                        + prefixSum[row][col-1]
                                        - prefixSum[row-1][col-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // get the sum of submatrices

        return prefixSum[row2 + 1][col2 + 1] 
        - prefixSum[row1][col2 + 1]
        - prefixSum[row2 + 1][col1]
        + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */