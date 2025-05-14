class Solution {
    /*
    Optimal approach - Kadane's Algorithm
    -> O(n) - TC
    -> O(1) - SC
    */

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for ( int i=1; i<nums.length; i++ ) {
            sum = Math.max( sum + nums[i], nums[i] );
            maxSum = Math.max( sum, maxSum );
        }
        // if ( maxSum < 0 ) return 0;
        return maxSum;
    }
}

/*
 - Brute force
 - Better Approach
 - Kadane's algorithm
*/

    /* 
    Brute force approach 
    -> O(n^3) - TC
    -> O(1) - SC
    
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;;
        for ( int i=0; i<nums.length; i++ ) {
            for ( int j=i; j<nums.length; j++ ) {
                int sum = 0;
                for ( int k=i; k<=j; k++ ) {
                    sum += nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    } 

    */

    /*
    Better approach 
    -> O(n^2) - TC
    -> O(1) - SC
    
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++ ) {
            int sum = 0;
            for ( int j=i; j<nums.length; j++ ) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
    */