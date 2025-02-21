class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix_product = new int[nums.length+1];
        int[] suffix_product = new int[nums.length+1];

        prefix_product[0] = 1;
        for ( int i=0; i<nums.length; i++ ) {
             prefix_product[i+1] = prefix_product[i] * nums[i];
        }

        suffix_product[nums.length] = 1;
        for ( int i=nums.length-1; i>=0; i-- ) {
             suffix_product[i] = suffix_product[i+1] * nums[i];
        }

        for ( int i=1; i<=nums.length; i++ ) {
             nums[i-1] = prefix_product[i-1] * suffix_product[i];
        }

        return nums;

    }
}