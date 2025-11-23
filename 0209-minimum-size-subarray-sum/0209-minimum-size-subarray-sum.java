class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int currSum = 0, minSize = Integer.MAX_VALUE, currSize = 0;

        while ( end < nums.length ) {
            currSum += nums[end];
            if ( currSum >= target ) {
                minSize = Math.min(minSize, end - start + 1);
                currSum -= nums[start];
                start++;
            }
            end++;
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize ;
    }
}