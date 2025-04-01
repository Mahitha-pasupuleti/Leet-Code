class Solution {
    public boolean checkBanana(int[] piles, int k, int h) {
        int hoursSpent = 0;
        for ( int i=0; i<piles.length; i++ ) {
            hoursSpent += Math.ceil((double)piles[i]/k);
            if ( hoursSpent > h ) {
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // get Max of the pile
        int maxValue = Integer.MIN_VALUE;
        for ( int i=0; i<piles.length; i++ ) {
            if ( maxValue < piles[i] ) maxValue = piles[i];
        }

        int low = 1, high = maxValue, mid = 0;
        while ( low <= high ) {
            mid = (low + high) / 2;
            if ( checkBanana(piles, mid, h) == true ) high = mid-1;
            else low = mid+1;
        }

        return low;
    }
}