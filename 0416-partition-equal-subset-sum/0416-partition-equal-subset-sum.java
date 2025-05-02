class Solution {
    Boolean[][] dp;
    public boolean subsetSum(int[] nums, int sum, int n) {
        if ( sum == 0 ) return true;
        if ( n == 0 ) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        if ( nums[n-1] <= sum ) {
            return dp[n][sum] = subsetSum(nums, sum-nums[n-1], n-1) || subsetSum( nums, sum, n-1);
        } 
        else return dp[n][sum] = subsetSum(nums, sum, n-1);
    }
    public boolean canPartition(int[] nums) {
        // if two distinct subsets have same sum, return true;
        // max can be sum/2
        // if we are able to get a subset with sum/2, then automatically the remaining value will be sum/2
        /*
         To explain clearly
         - [1, 5, 11, 5]
         - total sum = 22
         - if we are able to find a subset whose indiviualSum = totoalSum/2
         - then the other subset individualSum will be automatically totalSum/2 as well
        */

        int targetSum = 0;
        for ( int num: nums ) {
            targetSum += num;
        }

        if ( targetSum % 2 != 0 ) return false;
        
        targetSum /= 2;

        dp = new Boolean[nums.length + 1][targetSum + 1];

        return subsetSum(nums, targetSum, nums.length);
    }
}