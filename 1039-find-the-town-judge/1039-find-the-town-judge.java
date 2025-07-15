class Solution {
    public int findJudge(int n, int[][] trust) {
        // [1, 2, 3]
        // [1, 1, 0] = outdegree
        // [0, 0, 2] = indegree
        // [1, 2, 3]
        // [1, 1, 1] = outdegree
        // [1, 0, 2] = indegree

        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for ( int i=0; i<trust.length; i++ ) {
            outDegree[ trust[i][0] - 1 ]++;
            inDegree[ trust[i][1] - 1 ]++;
        }

        for ( int i=0; i<n; i++ ) {
            if ( outDegree[i] == 0 && inDegree[i] == n-1 ) return i+1;
        }
        return -1;
    }
}