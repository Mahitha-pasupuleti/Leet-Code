class Solution {
    public int[][] largestLocal(int[][] grid) {
        // int n = grid.length;
        // for ( int i=0; i<n; i++ ) {
        //     for ( int j=n-2; j>=0; j-- ) {
        //         if ( grid[i][j] < grid[i][j+1] ) {
        //             grid[i][j] = grid[i][j+1];
        //         }
        //     }
        // }

        // for ( int i=0; i<n; i++ ) {
        //     for ( int j=0; j<n; j++ ) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for ( int j=0; j<n; j++ ) {
        // for ( int i=n-2; i>=0; i-- ) {
        //         if ( grid[i][j] < grid[i+1][j] ) {
        //             grid[i][j] = grid[i+1][j];
        //         }
        //     }
        // }

        // for ( int i=0; i<n; i++ ) {
        //     for ( int j=0; j<n; j++ ) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // int[][] resultGrid = new int[n-2][n-2];
        // for ( int i=0; i<n-2; i++ ) {
        //     for ( int j=0; j<n-2; j++ ) {
        //         resultGrid[i][j] = grid[i][j];
        //     }
        // }

        // return resultGrid;

        int n = grid.length;
        int[][] resultGrid = new int[n-2][n-2];

        for ( int i=0; i<n-2; i++ ) {
            for ( int j=0; j<n-2; j++ ) {
                resultGrid[i][j] = 0;
            }
        }

        for ( int i=0; i<n-2; i++ ) {
            for ( int j=0; j<n-2; j++ ) {

                for ( int row=i; row < i+3; row++ ) {
                    for ( int col=j; col < j+3; col++ ) {
                        resultGrid[i][j] = Math.max(resultGrid[i][j], grid[row][col]);
                    }
                }

            }
        }

        return resultGrid;
    }
}