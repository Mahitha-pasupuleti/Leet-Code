/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int binarySearchLeft(int target, MountainArray mountainArr, int start, int end) {
        while ( start <= end ) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if ( midVal == target ) return mid;
            else if ( midVal < target ) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    private int binarySearchRight(int target, MountainArray mountainArr, int start, int end) {
        while ( start <= end ) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if ( midVal == target ) return mid;
            else if ( midVal < target ) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find peak element
        int n = mountainArr.length()-1;
        int start = 0, end = n;
        while ( start < end ) {
            int mid = start + (end - start) / 2;
            if ( mountainArr.get(mid) < mountainArr.get(mid+1) ) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        int peakEle = start;
        
        if ( mountainArr.get(peakEle) == target ) return peakEle;

        int toLeft = binarySearchLeft(target, mountainArr, 0, peakEle-1);
        int toRight = binarySearchRight(target, mountainArr, peakEle+1, n);

        if ( toLeft != -1 ) return toLeft;

        return toRight;
    }
}