class Solution {
    public boolean checkValid(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for ( int i=0; i<rows; i++ ) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for ( int j=0; j<cols; j++ ) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if ( rowSet.size() != rows || colSet.size() != cols ) return false;
        }
        return true;
    }
}