class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for ( int i=1; i<nums.length; i++ ) {
            output[i] = output[i-1] + nums[i];
        }

        int sum = 0;
        for ( int i=nums.length-1; i>=0; i-- ) {
            sum += nums[i];
            output[i] = Math.abs(output[i] - sum);
        }

        return output;
    }
}