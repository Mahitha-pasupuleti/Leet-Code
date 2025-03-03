class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for ( int i=0; i<n; i++ ) {
            if ( n%2 != 0 && i == Math.floor(n/2) ) {
                sum += mat[i][i];
            } else {
                sum += mat[i][i];
                sum += mat[i][n-1-i];
            }
        }
        return sum;
    }
}