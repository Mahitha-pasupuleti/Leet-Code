class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length;
        int mid = 0;

        while ( start < end ) {
            mid = start + ( end - start ) / 2;
            if ( nums[mid] > mid ) end = mid;
            else start = mid+1;
        }

        return start;
    }
}