class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 1 ) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // System.out.println(Arrays.toString(rowCount));
        // System.out.println(Arrays.toString(colCount));

        int connectedServers = 0;

        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<m; j++ ) {
                if ( grid[i][j] == 1 && (rowCount[i]>1 || colCount[j]>1) ) connectedServers++;
            }
        }

        return connectedServers;
    }
}