class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xorArr = new int[n];
        xorArr[0] = arr[0];
        for ( int i=1; i<n; i++ ) {
            xorArr[i] = xorArr[i-1] ^ arr[i];
        }

        int count = 0;

        for ( int i=0; i<n-1; i++ ) {
            for ( int k=i+1; k<n; k++ ) {
                if ((i == 0 && xorArr[k] == 0) || (i > 0 && (xorArr[k] ^ xorArr[i-1]) == 0)) {
                    count += (k - i);
                }
            }
        }

        // // int i=0, j=1, k=2;
        // for ( int i=0; i<n-2; i++ ) {
        //     for ( int j=i+1; j<n-1; j++ ) {
        //         for ( int k=j+1; k<n; k++ ) {
        //             int value = xorArr[k] ^ xorArr[j-1];
        //             if ( value == xorArr[j-1] ) count += (k-j+1);
        //         }
        //     }
        // }
        return count;
    }
}