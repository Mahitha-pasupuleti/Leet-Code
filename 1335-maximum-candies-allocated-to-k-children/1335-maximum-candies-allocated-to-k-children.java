class Solution {
    public boolean checkResult(int[] candies, int mid, long k) {
        long count = 0;
        for ( int i=0; i<candies.length; i++ ) {
            count += candies[i]/mid;
        }
        if ( count >= k ) return true;
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        // total no.of candies should be less then children else 0;
        int maxValue = Integer.MIN_VALUE;
        for ( int i=0; i<candies.length; i++ ) {
            if ( candies[i] > maxValue ) maxValue = candies[i];
        }

        int low = 1, high = maxValue, mid = 0;
        while ( low <= high ) {
            mid = (low + high)/2;
            if ( checkResult(candies, mid, k) ) low = mid+1;
            else high = mid-1;
        }

        return high;
    }
}