class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // int i=0, j=0;
        // int n1 = nums1.length;
        // int n2 = nums2.length;

        // while ( i < n1 && j < n2 ) {
        //     if ( nums1[i] < nums2[j] ) i++;
        //     else if ( nums1[i] > nums2[j] ) j++;
        //     else if ( nums1[i] == nums2[j] ) return nums1[i];
        // }

        // return -1;

        int n1 = nums1.length;
        int n2 = nums2.length;

        for ( int x : nums1 ) {
            int left = 0, right = n2-1;
            while ( left <= right ) {
                int mid = (left + right) / 2;
                if ( nums2[mid] == x ) return x;
                else if ( nums2[mid] > x ) right = mid-1;
                else left = mid+1; 
            }
        }
        return -1;
    }
}