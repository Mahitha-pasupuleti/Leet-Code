class Solution {
    private boolean isCondition(int[] nums, int k, int largestSum) {
        // if unable to cut into k, go below
        // else true go above
        int currSum = 0;
        for ( int i=0; i<nums.length; i++ ) {
            if ( currSum + nums[i] > largestSum ) {
                k--;
                if ( k == 0 ) return false;
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
        }
        // if ( k > 0 ) return false; // too much big need smaller number
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int totalSum = 0;
        for ( int num : nums ) {
            totalSum += num;
            maxVal = Math.max(maxVal, num);
        }

        int start = maxVal, end = totalSum, result = 0;
        while ( start <= end ) {
            int mid = start + (end - start) / 2;
            if ( isCondition(nums, k, mid) ) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return result;
    }
}