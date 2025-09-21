class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];

        for ( int row=1; row<=m; row++ ) {
            for ( int col=1; col<=n; col++ ) {
                prefix[row][col] = matrix[row-1][col-1] 
                + prefix[row-1][col] 
                + prefix[row][col-1] 
                - prefix[row-1][col-1];
            }
        }

        int maxSumBelowK = Integer.MIN_VALUE;

        for ( int row1=1; row1<=m; row1++ ) {
            for ( int row2=row1; row2<=m; row2++ ) {
                for ( int col1=1; col1<=n; col1++ ) {
                    for ( int col2=col1; col2<=n; col2++ ) {
                        int prefixSum = prefix[row2][col2] - prefix[row1-1][col2] - prefix[row2][col1-1] + prefix[row1-1][col1-1];
                        if ( prefixSum <= k ) maxSumBelowK = Math.max(maxSumBelowK, prefixSum);
                    }
                }
            }
        }

        return maxSumBelowK;

        // for ( int row1=1; row1<=m; row1++ ) {
        //     for ( int row2=row1; row2<=m; row2++ ) {
        //         Map<Integer, Integer> map = new HashMap<>();
        //         map.put(0, 1);
        //         int currSum = Integer.MIN_VALUE;
        //         for ( int col=1; col<=n; col++ ) {
        //             currSum = prefix[row2][col] - prefix[row1-1][col];
        //             map.putIfAbsent(currSum, 1);
        //         }
        //     }
        // }
        // return maxSumBelowK;
    }
}