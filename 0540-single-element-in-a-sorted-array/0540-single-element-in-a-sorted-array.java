class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0, right = nums.length-1;
        int mid = 0;

        while ( left < right ) {
            mid = left + (right - left) / 2;
                if ( nums[mid-1] == nums[mid] ) {
                    if ( mid % 2 == 0 ) {
                        right = mid-2;
                    } else {
                        left = mid+1;
                    }
                } else if ( nums[mid] == nums[mid+1] ) {
                    if ( mid % 2 == 0 ) {
                        left = mid+2;
                    } else {
                        right = mid-1;
                    }
                } else {
                    return nums[mid];
                }
        }
        return nums[left];
    }
}