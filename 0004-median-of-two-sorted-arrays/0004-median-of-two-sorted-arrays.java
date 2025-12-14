class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m+n];
        int index = 0;

        int x = 0, y = 0;
        while ( x < m && y < n ) {
            if ( nums1[x] < nums2[y] ) {
                result[index++] = nums1[x++];
            } else {
                result[index++] = nums2[y++];
            }
        }

        while ( x < m ) {
            result[index++] = nums1[x++];
        }

        while ( y < n ) {
            result[index++] = nums2[y++];
        }
        
        int len = result.length;
        if ( len%2 == 0 )
        return (double)(result[len/2] + result[len/2 - 1]) / 2;

        return (double)result[len/2];
    }
}