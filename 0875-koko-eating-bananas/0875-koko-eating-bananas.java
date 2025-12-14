class Solution {
    private boolean isCondition(int[] piles, int k, int h) {
        for ( int i=0; i<piles.length; i++ ) {
            int hours = (int)Math.ceil((double)piles[i]/k);
            h -= hours;
            if ( h < 0 ) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for ( int pile : piles ) {
            high = Math.max(high, pile);
        }

        int low = 1, result = 0;
        while ( low <= high ) {
            int mid = low + (high - low) / 2;
            if ( isCondition(piles, mid, h) ) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;
    }
}