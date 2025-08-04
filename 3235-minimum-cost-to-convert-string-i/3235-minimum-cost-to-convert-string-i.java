class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int[][] costMatrix = new int[26][26];

        for ( int i=0; i<26; i++ ) {
            for ( int j=0; j<26; j++ ) {
                if ( i == j ) costMatrix[i][j] = 0;
                else costMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for ( int i=0; i<n; i++ ) {
            int org = original[i] - 'a';
            int cha = changed[i] - 'a';
            costMatrix[org][cha] = Math.min(costMatrix[org][cha], cost[i]);
        }

        for ( int k=0; k<26; k++ ) {
            for ( int i=0; i<26; i++ ) {
                for ( int j=0; j<26; j++ ) {
                    if ( costMatrix[i][k] != Integer.MAX_VALUE && costMatrix[k][j] != Integer.MAX_VALUE ) {
                        costMatrix[i][j] = Math.min( costMatrix[i][j], costMatrix[i][k] + costMatrix[k][j] );
                    }
                }
            }
        }

        // for ( int i=0; i<26; i++ ) {
        //     for ( int j=0; j<26; j++ ) {
        //         System.out.print( costMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        long minCost = 0;
        for ( int i=0; i<source.length(); i++ ) {
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';
            if ( costMatrix[src][tar] == Integer.MAX_VALUE ) return -1;
            minCost += costMatrix[src][tar];
        }

        return minCost;

    }
}