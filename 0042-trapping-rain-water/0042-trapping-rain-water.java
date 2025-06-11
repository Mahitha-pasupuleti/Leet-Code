class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];

        int[] suffixMax = new int[n];
        suffixMax[n-1] = height[n-1];

        for ( int i=1; i<n; i++ ) {
            if ( prefixMax[i-1] < height[i] ) {
                prefixMax[i] = height[i];
            } else {
                prefixMax[i] = prefixMax[i-1];
            }
        }
        // System.out.println( Arrays.toString( prefixMax ) );

        for ( int i=n-2; i>=0; i-- ) {
            if ( suffixMax[i+1] < height[i] ) {
                suffixMax[i] = height[i];
            } else {
                suffixMax[i] = suffixMax[i+1];
            }
        }
        // System.out.println( Arrays.toString( suffixMax ) );

        int water = 0;
        for ( int i=0; i<n; i++ ) {
            if ( height[i] < prefixMax[i] && height[i] < suffixMax[i] ) {
                water += Math.min( prefixMax[i], suffixMax[i] ) - height[i];
            }
        }

        return water;
    }
}