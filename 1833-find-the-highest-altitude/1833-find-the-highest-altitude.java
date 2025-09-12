class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitudeReached = currentAltitude;
        for ( int i=0; i<gain.length; i++ ) {
            currentAltitude += gain[i];
            maxAltitudeReached = Math.max(maxAltitudeReached, currentAltitude);
        }
        return maxAltitudeReached;
    }
}