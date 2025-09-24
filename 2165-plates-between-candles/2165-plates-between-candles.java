class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] prefixSum = new int[n+1];
        for ( int i=0; i<n; i++ ) {
            prefixSum[i+1] = prefixSum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }

        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];

        int leftCandleIndex = -1;
        for ( int i=0; i<n; i++ ) {
            if ( s.charAt(i) == '|' ) leftCandleIndex = i;
            leftCandle[i] = leftCandleIndex;
        }

        int rightCandleIndex = -1;
        for ( int i=n-1; i>=0; i-- ) {
            if ( s.charAt(i) == '|' ) rightCandleIndex = i;
            rightCandle[i] = rightCandleIndex;
        }

        int[] result = new int[queries.length];
        for ( int i=0; i<queries.length; i++ ) {
            int cLeft = rightCandle[ queries[i][0] ];
            int cRight = leftCandle[ queries[i][1] ];
            if ( cLeft != -1 && cRight != -1 && cLeft < cRight ) {
                result[i] = prefixSum[ cRight ] - prefixSum[ cLeft ];
            }
        }

        return result;
    }
}