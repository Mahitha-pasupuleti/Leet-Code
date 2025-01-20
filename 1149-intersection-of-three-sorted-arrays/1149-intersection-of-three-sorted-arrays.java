class Solution {
    public boolean binarySearch( int[] arr, int x ) {
        int start = 0, end = arr.length-1, mid = 0;
        while ( start <= end ) {
            mid = start + ( end - start ) / 2;
            if ( arr[mid] == x ) return true;
            else if ( arr[mid] < x ) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> result = new ArrayList<>();

        if ( arr1.length == 0 || arr2.length == 0 || arr3.length == 0 ) return result;

        for ( int i=0; i<arr1.length; i++ ) {
            if ( binarySearch(arr2, arr1[i]) ) {
                if ( binarySearch(arr3, arr1[i]) ) {
                    result.add(arr1[i]);
                }
            }
        }

        return result;
        
    }
}