class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] weightMatrix = new int[n][n];
        for ( int i=0; i<n; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( i == j ) weightMatrix[i][j] = 0;
                else weightMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for ( int[] edge : edges ) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            weightMatrix[x][y] = w;
            weightMatrix[y][x] = w;
        }

        // for ( int i=0; i<n; i++ ) {
        //     for ( int j=0; j<n; j++ ) {
        //         System.out.print( weightMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for ( int k = 0; k<n; k++ ) {
            for ( int i=0; i<n; i++ ) {
                for ( int j=0; j<n; j++ ) {
                    if (weightMatrix[i][k] != Integer.MAX_VALUE && weightMatrix[k][j] != Integer.MAX_VALUE) {
                        weightMatrix[i][j] = Math.min(weightMatrix[i][j], weightMatrix[i][k] + weightMatrix[k][j]);
                    }
                }
            }
        }

        int minCityNeighborsWithinThreshold = Integer.MAX_VALUE;
        int resultCity = -1;
        for ( int i=0; i<n; i++ ) {
            int currentCityNeighborsWithinThreshold = 0;
            for ( int j=0; j<n; j++ ) {
                if ( i == j ) continue;
                if ( weightMatrix[i][j] <= distanceThreshold ) currentCityNeighborsWithinThreshold++;
            }
            if ( currentCityNeighborsWithinThreshold <= minCityNeighborsWithinThreshold ) {
                minCityNeighborsWithinThreshold = currentCityNeighborsWithinThreshold;
                resultCity = i;
            }
        }

        return resultCity;

    }
}