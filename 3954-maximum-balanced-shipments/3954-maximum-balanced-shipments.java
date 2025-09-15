class Solution {
    public int maxBalancedShipments(int[] weight) {
        int noofBalancedShipments = 0;
        int maxWeightTillNow = 0;

        for ( int i=0; i<weight.length; i++ ) {
            if ( maxWeightTillNow > weight[i] ) {
                noofBalancedShipments++;
                maxWeightTillNow = 0;
            } else {
                maxWeightTillNow = weight[i]; // change the current max weight
            }
        }

        return noofBalancedShipments;
    }
}