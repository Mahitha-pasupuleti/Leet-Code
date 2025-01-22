class Solution {
    public boolean satisfyingCondition(int[] weights, int days, int capacity) {

        int sum = 0;
        for ( int i=0; i<weights.length; i++ ) {
            if ( days == 0 ) return false;
            sum += weights[i];
            if ( sum >= capacity ) {
                if ( sum > capacity ) i--;
                days--;
                sum = 0;
            }
        }
        return true;

    }
    public int shipWithinDays(int[] weights, int days) {
        
        // sum of weights
        int high = 0;
        for ( int i=0; i<weights.length; i++ ) {
            high += weights[i];
        }

        int low = 1, mid = 0, result = 0;

        while ( low <= high ) {
            mid = low + (high - low) / 2;
            if ( satisfyingCondition(weights, days, mid) ) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;

    }
}