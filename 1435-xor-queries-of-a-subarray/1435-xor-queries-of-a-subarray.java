class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix_XOR = new int[arr.length];
        prefix_XOR[0] = arr[0]; 
        for ( int i=1; i<arr.length; i++ ) {
            prefix_XOR[i] = prefix_XOR[i-1] ^ arr[i];
        }
        // for ( int i=0; i<arr.length; i++ ) {
        //     System.out.print(prefix_XOR[i] + " ");
        // }

        int[] output = new int[queries.length];
        for ( int i=0; i<queries.length; i++ ) {
            int start = queries[i][0];
            int end = queries[i][1];
            if ( start == 0 ) output[i] = prefix_XOR[end];
            else if ( start == end ) output[i] = prefix_XOR[end] ^ prefix_XOR[end-1];
            else output[i] = prefix_XOR[end] ^ prefix_XOR[start-1];
        }
        return output;
    }
}