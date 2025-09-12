class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for ( int i=1; i<travel.length; i++ ) {
            travel[i] += travel[i-1];
        }
        int totalGarbage = 0, lastG = 0, lastM = 0, lastP = 0;

        for ( int i=0; i<garbage.length; i++ ) {
            totalGarbage += garbage[i].length();
            if ( garbage[i].contains("G") ) lastG = i;
            if ( garbage[i].contains("M") ) lastM = i;
            if ( garbage[i].contains("P") ) lastP = i;
        }

        int travelG = lastG != 0 ? travel[lastG - 1] : 0;
        int travelM = lastM != 0 ? travel[lastM - 1] : 0;
        int travelP = lastP != 0 ? travel[lastP - 1] : 0;

        return totalGarbage + travelG + travelM + travelP;
    }
}