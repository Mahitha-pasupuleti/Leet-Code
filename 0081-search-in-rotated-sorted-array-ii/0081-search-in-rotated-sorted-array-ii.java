class Solution {
    private boolean binarySearch(int start, int end, int[] nums, int target) {
        while ( start <= end ) {
            int mid = start + (end - start) / 2;
            if ( nums[mid] == target ) return true;
            else if ( nums[mid] > target ) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        while ( start < end ) {
            int mid = start + (end - start) / 2;
            if ( nums[mid] == nums[start] && nums[mid] == nums[end] ) {
                start++;
                end--;
            } else {
                break;
            }
        }
        int low = start, high = end;
        while ( low < high ) {
            int mid = low + (high - low) / 2;
            if ( nums[mid] > nums[high] ) low = mid+1;
            else high = mid;
        }
        if ( nums[low] == target ) return true;

        return binarySearch(start, low-1, nums, target) || binarySearch(low+1, end, nums, target);
    }
}