class Solution {
    // unique problems, the current XOR needs to be passed in the recursion so it can be added later 
    public int helper(int[] nums, int i, int currentXor) {
        if ( i == nums.length ) return currentXor;
        int pick = helper(nums, i+1, nums[i]^currentXor); // 5^0 // 1^5^0 // 6^1^5^0 
        int noPick = helper(nums, i+1, currentXor); // 6^1^0
        return pick + noPick;
    }
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
}