class Solution {
    private boolean squareExists(int[][] prefix, int k, int threshold) {
        int m = prefix.length-1, n = prefix[0].length-1;
        for ( int i=k; i<=m; i++ ) {
            for ( int j=k; j<=n; j++ ) {
                int value = prefix[i][j] - prefix[i-k][j] - prefix[i][j-k] + prefix[i-k][j-k];
                if ( value <= threshold ) return true;
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m+1][n+1];

        for ( int i=1; i<=m; i++ ) {
            for ( int j=1; j<=n; j++ ) {
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        // for ( int i=0; i<=m; i++ ) {
        //     for ( int j=0; j<=n; j++ ) {
        //         System.out.print( prefix[i][j] + " " );
        //     }
        //     System.out.println();
        // }

        int low = 1, high = Math.min(m, n), side = 0;

        while ( low <= high ) {
            int mid = low + (high - low) / 2;
            if ( squareExists(prefix, mid, threshold) ) {
                low = mid+1;
                side = mid;
            } else {
                high = mid-1;
            }
        }

        return side;
    }
}