class Solution {
    public int countPartitions(int[] nums) {
        
        int sum = 0;
        for ( int i=0; i<nums.length; i++ ) sum += nums[i];

        int currSum = 0;
        int count = 0;
        for ( int i=0; i<nums.length-1; i++ ) {
            currSum += nums[i];
            if ( (sum - 2*currSum)%2 == 0 ) count++;
        }

        return count;
    }
}